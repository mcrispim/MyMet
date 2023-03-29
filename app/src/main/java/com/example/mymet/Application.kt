package com.example.mymet

import android.app.Application
import com.example.mymet.network.RetrofitHelper
import com.example.mymet.data.model.ObjectService
import com.example.mymet.db.ObjectDatabase
import com.example.mymet.repository.MuseumObjectRepository

class Application: Application() {
    lateinit var museumObjectRepository: MuseumObjectRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val service = RetrofitHelper(applicationContext).getInstance().create(ObjectService::class.java)
        val database = ObjectDatabase.getDataBase(applicationContext)
        museumObjectRepository = MuseumObjectRepository(database as ObjectDatabase, service)
    }

}
