package com.unilifeai

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData

class HomeViewModel(private val timetableRepository: TimetableRepository) : ViewModel() {

    val timetableEntries: LiveData<List<TimetableEntry>> = timetableRepository.allTimetableEntries.asLiveData()

}
