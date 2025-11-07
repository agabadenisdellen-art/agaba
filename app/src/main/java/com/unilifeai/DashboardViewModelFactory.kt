package com.unilifeai

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DashboardViewModelFactory(
    private val timetableRepository: TimetableRepository,
    private val alarmRepository: AlarmRepository,
    private val shoppingRepository: ShoppingRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DashboardViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DashboardViewModel(timetableRepository, alarmRepository, shoppingRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
