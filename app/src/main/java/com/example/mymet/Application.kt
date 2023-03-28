package com.example.mymet

import android.app.Application
import com.example.mymet.data.api.RetrofitHelper
import com.example.mymet.data.model.ObjectService
import com.example.mymet.data.repository.ObjectRepository

class Application: Application() {
    lateinit var objectsRepository: ObjectRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val service = RetrofitHelper(applicationContext).getInstance().create(ObjectService::class.java)
//        val database = ObjectDatabase.getDataBase(applicationContext)
        objectRepository = ObjectrRepository(service, database)
    }

}
