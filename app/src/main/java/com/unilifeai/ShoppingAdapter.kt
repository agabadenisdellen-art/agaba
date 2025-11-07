package com.unilifeai

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ShoppingAdapter(
    private var items: List<ShoppingItem>,
    private val onUpdate: (ShoppingItem) -> Unit,
    private val onDelete: (ShoppingItem) -> Unit
) : RecyclerView.Adapter<ShoppingAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val checkBox: CheckBox = view.findViewById(R.id.checkBoxBought)
        val nameTextView: TextView = view.findViewById(R.id.textViewItemName)
        val deleteButton: ImageButton = view.findViewById(R.id.buttonDeleteItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_shopping, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.nameTextView.text = item.name
        holder.checkBox.isChecked = item.isBought

        // Strikethrough text if bought
        holder.nameTextView.paintFlags = if (item.isBought) {
            holder.nameTextView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            holder.nameTextView.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            onUpdate(item.copy(isBought = isChecked))
        }

        holder.deleteButton.setOnClickListener {
            onDelete(item)
        }
    }

    override fun getItemCount() = items.size

    fun updateData(newItems: List<ShoppingItem>) {
        items = newItems
        notifyDataSetChanged()
    }
}
