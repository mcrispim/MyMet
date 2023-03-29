package com.example.mymet.repository

import com.example.mymet.models.MuseumObjectIdList
import com.example.mymet.data.model.ObjectService
import com.example.mymet.db.ObjectDatabase
import com.example.mymet.models.MuseumObject

class MuseumObjectRepository(
    private val database: ObjectDatabase,
    private val service: ObjectService,
) {
    lateinit var objectIdList: MuseumObjectIdList
    lateinit var nObjects: List<MuseumObject>

    suspend fun getObjectIds() {
        val resObjectIds = service.getObjectIds()
        if (resObjectIds.body() != null) {
            objectIdList = resObjectIds.body()!!
        }
    }

    suspend fun getObjects(n: Int): List<MuseumObject> {
        val ids = List<MuseumObject>(n) {
            val id = objectIdList.objectIds.random()
            val resObjectById = service.getObjectById(id)

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