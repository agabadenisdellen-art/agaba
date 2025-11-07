package com.unilifeai

import android.app.TimePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*

class AlarmActivity : AppCompatActivity() {

    private lateinit var alarmViewModel: AlarmViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AlarmAdapter
    private lateinit var fabAddAlarm: FloatingActionButton
    private lateinit var alarmScheduler: AlarmScheduler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        alarmScheduler = AlarmScheduler(this)

        val database = (application as UniLifeApplication).database
        val repository = AlarmRepository(database.alarmDao())
        val factory = AlarmViewModelFactory(repository)
        alarmViewModel = ViewModelProvider(this, factory).get(AlarmViewModel::class.java)

        recyclerView = findViewById(R.id.recyclerViewAlarms)
        recyclerView.layoutManager = LinearLayoutManager(this)

        alarmViewModel.allAlarms.observe(this, { alarms ->
            alarms?.let {
                adapter = AlarmAdapter(it) { alarm ->
                    // Handle toggle
                    alarmViewModel.update(alarm)
                    if (alarm.isEnabled) {
                        alarmScheduler.schedule(alarm)
                    } else {
                        alarmScheduler.cancel(alarm)
                    }
                }
                recyclerView.adapter = adapter
            }
        })

        fabAddAlarm = findViewById(R.id.fabAddAlarm)
        fabAddAlarm.setOnClickListener {
            // Show a TimePickerDialog to add a new alarm
            val calendar = Calendar.getInstance()
            TimePickerDialog(this, { _, hourOfDay, minute ->
                val newAlarm = Alarm(time = "$hourOfDay:$minute", label = "New Alarm")
                alarmViewModel.insert(newAlarm)
                alarmScheduler.schedule(newAlarm)
            }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show()
        }
    }
}
