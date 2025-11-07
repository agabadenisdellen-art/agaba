package com.unilifeai

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData

class DashboardViewModel(
    private val timetableRepository: TimetableRepository,
    private val alarmRepository: AlarmRepository,
    private val shoppingRepository: ShoppingRepository
) : ViewModel() {

    val timetableEntries: LiveData<List<TimetableEntry>> = timetableRepository.allTimetableEntries.asLiveData()
    val alarms: LiveData<List<Alarm>> = alarmRepository.allAlarms.asLiveData()
    val shoppingItems: LiveData<List<ShoppingItem>> = shoppingRepository.allItems.asLiveData()

    // In a real app, the summary logic would be more complex,
    // tracking actual attended classes, completed alarms, etc.
    // For now, we'll just count them.
    fun getClassesTodayCount(timetable: List<TimetableEntry>): Int {
        val calendar = java.util.Calendar.getInstance()
        val dayOfWeek = calendar.getDisplayName(java.util.Calendar.DAY_OF_WEEK, java.util.Calendar.LONG, java.util.Locale.getDefault())
        return timetable.count { it.day.equals(dayOfWeek, ignoreCase = true) }
    }

    fun getCompletedAlarmsCount(alarms: List<Alarm>): Int {
        // Placeholder
        return alarms.count { !it.isEnabled }
    }

    fun getItemsBoughtCount(items: List<ShoppingItem>): Int {
        return items.count { it.isBought }
    }
}
