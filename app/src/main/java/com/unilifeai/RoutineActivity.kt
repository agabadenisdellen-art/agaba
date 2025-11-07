package com.unilifeai

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RoutineActivity : AppCompatActivity() {

    private lateinit var timetableViewModel: TimetableViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TimetableAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_routine)

        // This would be initialized with a proper dependency injection framework
        val database = (application as UniLifeApplication).database
        val repository = TimetableRepository(database.timetableDao())
        val factory = TimetableViewModelFactory(repository)
        timetableViewModel = ViewModelProvider(this, factory).get(TimetableViewModel::class.java)

        recyclerView = findViewById(R.id.recyclerViewTimetable)
        recyclerView.layoutManager = LinearLayoutManager(this)

        timetableViewModel.allTimetableEntries.observe(this, { entries ->
            entries?.let {
                adapter = TimetableAdapter(it)
                recyclerView.adapter = adapter
            }
        })
    }
}
