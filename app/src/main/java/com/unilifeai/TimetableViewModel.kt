package com.unilifeai

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TimetableViewModel(private val repository: TimetableRepository) : ViewModel() {

    val allTimetableEntries: LiveData<List<TimetableEntry>> = repository.allTimetableEntries.asLiveData()

    init {
        viewModelScope.launch {
            repository.prePopulateTimetableIfEmpty()
        }
    }
}
