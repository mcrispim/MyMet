package com.example.mymet.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ObjectViewModel: ViewModel() {
    private val service = ObjectService()
    lateinit var objectIds: ObjectIdList

    fun fetchObjectIds() {
        viewModelScope.launch(Dispatchers.IO) {
            val res = service.fetchObjectIds()

            if (res.isSuccessful) {
                withContext(Dispatchers.Main) {
                    objectIds = res.body()!!
                }
            }
        }
    }
}
