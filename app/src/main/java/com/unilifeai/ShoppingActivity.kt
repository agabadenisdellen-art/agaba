package com.unilifeai

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShoppingActivity : AppCompatActivity() {

    private lateinit var shoppingViewModel: ShoppingViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ShoppingAdapter
    private lateinit var editTextNewItem: EditText
    private lateinit var buttonAddItem: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val database = (application as UniLifeApplication).database
        val repository = ShoppingRepository(database.shoppingItemDao())
        val factory = ShoppingViewModelFactory(repository)
        shoppingViewModel = ViewModelProvider(this, factory).get(ShoppingViewModel::class.java)

        editTextNewItem = findViewById(R.id.editTextNewItem)
        buttonAddItem = findViewById(R.id.buttonAddItem)
        recyclerView = findViewById(R.id.recyclerViewShopping)
        recyclerView.layoutManager = LinearLayoutManager(this)

        shoppingViewModel.allItems.observe(this, { items ->
            items?.let {
                if (!::adapter.isInitialized) {
                    adapter = ShoppingAdapter(it,
                        onUpdate = { item -> shoppingViewModel.update(item) },
                        onDelete = { item -> shoppingViewModel.delete(item) }
                    )
                    recyclerView.adapter = adapter
                } else {
                    adapter.updateData(it)
                }
            }
        })

        buttonAddItem.setOnClickListener {
            val itemName = editTextNewItem.text.toString()
            if (itemName.isNotBlank()) {
                // Category is hardcoded for now, could be improved with a Spinner/Dialog
                shoppingViewModel.insert(ShoppingItem(name = itemName, category = "Groceries"))
                editTextNewItem.text.clear()
            }
        }
    }
}
