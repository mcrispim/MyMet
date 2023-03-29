package com.example.mymet.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymet.network.RetrofitHelper
import com.example.mymet.data.model.ObjectIdList
import com.example.mymet.models.MuseumObject
import com.example.mymet.repository.MuseumObjectRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

const val NUMBER_OF_OBJECTS = 10
class MuseumObjectViewModel(private val repository: MuseumObjectRepository): ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getObjectIds()
            if (repository.objectIdList == null) {
                throw Exception("Can't get the museumObjectList!")
            }
//            repository.getCharsById(21)
//            repository.getCharsDB()
        }
    }

    val museumObjectsList: LiveData<List<MuseumObject>>
        get() = repository.


    private val service = RetrofitHelper.objectService
    var objectIds: ObjectIdList? = null

    fun getObjectIds() {
        viewModelScope.launch(Dispatchers.IO) {
            objectIds = service.fetchObjectIds()
        }.join()
    }
}

class CharViewModel(
    private val repository: CharRepository
): ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getChars()
            repository.getCharsById(21)

            repository.getCharsDB()
        }
    }

    val chars: LiveData<CharactersList>
        get() = repository.itemsCharList

    val charsDB: LiveData<List<Char>>
        get() = repository.itemsCharListDB

    val charById: LiveData<CharTeste>
        get() = repository.itemsCharbyId
}
