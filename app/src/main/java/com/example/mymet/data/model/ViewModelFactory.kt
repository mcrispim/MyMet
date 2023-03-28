package com.example.mymet.data.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mymet.data.repository.ObjectRepository

class ViewModelFactory(private val repository: ObjectRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ObjectViewModel(repository) as T
    }
}