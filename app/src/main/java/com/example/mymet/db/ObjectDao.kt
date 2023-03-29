package com.example.mymet.db

import androidx.room.*

@Dao
interface MuseumObjectDao {
    @Insert
    fun addMuseumObject(museumObject: List<com.example.mymet.models.MuseumObject>)

    @Query("SELECT * FROM museumObject")
    fun fetchMuseumObject(): List<com.example.mymet.models.MuseumObject>

    @Update
    fun updateMuseumObject(museumObject: com.example.mymet.models.MuseumObject)

    @Delete
    fun deleteMuseumObject(museumObject: com.example.mymet.models.MuseumObject)

}
