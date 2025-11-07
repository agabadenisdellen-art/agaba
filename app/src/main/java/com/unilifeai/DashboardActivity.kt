package com.unilifeai

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class DashboardActivity : AppCompatActivity() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val database = (application as UniLifeApplication).database
        val timetableRepo = TimetableRepository(database.timetableDao())
        val alarmRepo = AlarmRepository(database.alarmDao())
        val shoppingRepo = ShoppingRepository(database.shoppingItemDao())

        val factory = DashboardViewModelFactory(timetableRepo, alarmRepo, shoppingRepo)
        dashboardViewModel = ViewModelProvider(this, factory).get(DashboardViewModel::class.java)

        val classesSummaryTv = findViewById<TextView>(R.id.textViewClassesSummary)
        val alarmsSummaryTv = findViewById<TextView>(R.id.textViewAlarmsSummary)
        val shoppingSummaryTv = findViewById<TextView>(R.id.textViewShoppingSummary)
        val nextActivityTv = findViewById<TextView>(R.id.textViewNextActivitySuggestion)
        val shoppingSuggestionTv = findViewById<TextView>(R.id.textViewShoppingSuggestion)

        dashboardViewModel.timetableEntries.observe(this, { timetable ->
            timetable?.let {
                classesSummaryTv.text = "Classes Today: ${dashboardViewModel.getClassesTodayCount(it)}"
                nextActivityTv.text = "Suggestion: ${AiPredictor.suggestNextActivity(it)}"
            }
        })

        dashboardViewModel.alarms.observe(this, { alarms ->
            alarms?.let {
                alarmsSummaryTv.text = "Alarms Completed: ${dashboardViewModel.getCompletedAlarmsCount(it)}"
            }
        })

        dashboardViewModel.shoppingItems.observe(this, { items ->
            items?.let {
                shoppingSummaryTv.text = "Items Bought: ${dashboardViewModel.getItemsBoughtCount(it)}"
                val frequentItems = AiPredictor.predictFrequentItems(it)
                shoppingSuggestionTv.text = "Frequent items: ${frequentItems.joinToString()}"
            }
        })
    }
}
