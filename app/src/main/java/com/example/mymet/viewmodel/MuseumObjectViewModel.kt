package com.example.mymet.viewmodel
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.mymet.network.RetrofitHelper
//import com.example.mymet.data.model.ObjectIdList
//import com.example.mymet.models.MuseumObject
//import com.example.mymet.repository.MuseumObjectRepository
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//
//// entre 1 e 897280 de um total de 484567
//const val NUMBER_OF_OBJECTS = 10
//
//
//class MuseumObjectViewModel(private val repository: MuseumObjectRepository) : ViewModel() {
//
//    // var museumObjectsList: List<MuseumObject> = repository.getObjects(NUMBER_OF_OBJECTS)
//    val museumObjectList: LiveData<List<MuseumObject>>
//        get() = repository.getObjects(NUMBER_OF_OBJECTS)
//
//    private val service = RetrofitHelper.
//
//}
//
//class CharViewModel(
//    private val repository: CharRepository
//) : ViewModel() {
//
//    init {
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.getChars()
//            repository.getCharsById(21)
//
//            repository.getCharsDB()
//        }
//    }
//
//    val chars: LiveData<CharactersList>
//        get() = repository.itemsCharList
//
//    val charsDB: LiveData<List<Char>>
//        get() = repository.itemsCharListDB
//
//    val charById: LiveData<CharTeste>
//        get() = repository.itemsCharbyId
//}
