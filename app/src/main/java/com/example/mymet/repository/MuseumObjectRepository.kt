package com.example.mymet.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mymet.models.MuseumObjectIdList
import com.example.mymet.db.ObjectDatabase
import com.example.mymet.models.MuseumObject
import com.example.mymet.network.ObjectService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Response

class MuseumObjectRepository(
    private val database: ObjectDatabase,
    private val service: ObjectService,
) {
    lateinit var objectIdList: MuseumObjectIdList
//
//    val museumObjects = LiveData<List<MuseumObject>>()
//        get() = _museumObjects

    fun getObjectIds() {
        var resObjectIds: Response<MuseumObjectIdList>
        CoroutineScope(IO).launch {
            resObjectIds = service.getObjectIds()
            if (resObjectIds.body() != null) {
                objectIdList = resObjectIds.body()!!
            }
        }

    }

    fun getObjects(n: Int): List<MuseumObject> {
        val objects = mutableListOf<MuseumObject>()
        while (objects.size < n) {
            val id = objectIdList.objectIds.random()
            CoroutineScope(IO).launch {
                val resObjectById = service.getObjectById(id)
                if (resObjectById.body() != null) {
                    objects.add(resObjectById.body()!!)
                }
            }
        }
        return objects.toList()
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