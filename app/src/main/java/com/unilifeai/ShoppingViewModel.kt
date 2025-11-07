package com.unilifeai

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repository: ShoppingRepository) : ViewModel() {

    val allItems: LiveData<List<ShoppingItem>> = repository.allItems.asLiveData()

    fun insert(item: ShoppingItem) = viewModelScope.launch {
        repository.insert(item)
    }

    fun update(item: ShoppingItem) = viewModelScope.launch {
        repository.update(item)
    }

    fun delete(item: ShoppingItem) = viewModelScope.launch {
        repository.delete(item)
    }
}
