package com.example.mymet.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [com.example.mymet.models.MuseumObject::class], version = 1)
abstract class ObjectDatabase : RoomDatabase() {

    abstract fun museumObjectDao(): MuseumObjectDao

    companion object {
        @Volatile
        private var INSTANCE: com.example.mymet.db.ObjectDatabase? = null

        fun getDataBase(context: Context): RoomDatabase {

            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        RoomDatabase::class.java,
                        "RmDB"
                    ).build() as com.example.mymet.db.ObjectDatabase
                }
            }
            return INSTANCE!!
        }
    }
}