package com.example.mymet.data.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymet.data.api.RetrofitHelper
import com.example.mymet.data.repository.ObjectRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ObjectViewModel(private val repository: ObjectRepository): ViewModel() {

    private val service = RetrofitHelper.objectService
    var objectIds: ObjectIdList? = null

    fun getObjectIds() {
        viewModelScope.launch(Dispatchers.IO) {
            objectIds = service.fetchObjectIds()
        }.join()
    }
}

