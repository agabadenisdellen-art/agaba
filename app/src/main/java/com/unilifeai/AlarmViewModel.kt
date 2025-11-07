package com.unilifeai

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AlarmViewModel(private val repository: AlarmRepository) : ViewModel() {

    val allAlarms: LiveData<List<Alarm>> = repository.allAlarms.asLiveData()

    fun insert(alarm: Alarm) = viewModelScope.launch {
        repository.insert(alarm)
    }

    fun update(alarm: Alarm) = viewModelScope.launch {
        repository.update(alarm)
    }

    fun delete(alarm: Alarm) = viewModelScope.launch {
        repository.delete(alarm)
    }
}
