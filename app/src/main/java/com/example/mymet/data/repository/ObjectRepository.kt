package com.example.mymet.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mymet.data.model.ObjectIdList
import com.example.mymet.data.model.ObjectService

class ObjectRepository (private val service: ObjectService) {
    private val _objectIds = MutableLiveData<ObjectIdList>()
    val objectIds: LiveData<ObjectIdList>
        get() = _objectIds

    suspend fun getObjectIds() {
        val resObjectIds = service.getObjectIds()
        if (resObjectIds.body() != null) {
            _objectIds.postValue(resObjectIds.body())
        }
    }

}


//class CharRepository(
//    private val rmService: RMService,
//    private val rmDatabase: RmDatabase
//) {
//
//    //CharList
//    private val _itemsCharList = MutableLiveData<CharactersList>()
//
//    val itemsCharList: LiveData<CharactersList>
//        get() = _itemsCharList
//
//
//
//    //CharList by DB
//    private val _itemsCharListDB = MutableLiveData<List<Char>>()
//    val itemsCharListDB: LiveData<List<Char>>
//        get() = _itemsCharListDB
//
//
//    //Char by id
//    private val _itemsCharbyId = MutableLiveData<CharTeste>()
//    val itemsCharbyId: LiveData<CharTeste>
//        get() = _itemsCharbyId
//
//
//    suspend fun getChars() {
//        val resChars = rmService.getChar()
//        if (resChars.body() != null) {
//            rmDatabase.charDao().addChar(resChars.body()!!.char)
//            _itemsCharList.postValue(resChars.body())
//        }
//    }
//
//    fun getCharsDB() {
//        _itemsCharListDB.postValue(rmDatabase.charDao().fetchChar())
//    }
//
//    suspend fun getCharsById(id: Int) {
//        val resCharById = rmService.getCharById(id)
//        if (resCharById.body() != null) {
//            _itemsCharbyId.postValue(resCharById.body())
//        }
//    }
//}