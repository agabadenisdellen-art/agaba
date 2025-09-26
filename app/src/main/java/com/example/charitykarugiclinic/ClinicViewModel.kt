package com.example.agabadenisclinic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ClinicViewModel(private val dao: ClinicDao) : ViewModel() {

    val allPatients: StateFlow<List<Patient>> = dao.getAllPatients()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    val allDoctors: StateFlow<List<Doctor>> = dao.getAllDoctors()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun addPatient(patient: Patient) = viewModelScope.launch {
        dao.addPatient(patient)
    }
}

class ClinicViewModelFactory(private val dao: ClinicDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ClinicViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ClinicViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class for Agaba Denis Clinic")
    }
}