package com.example.mymet.data.api

import android.content.Context
import com.example.mymet.data.model.ObjectService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://collectionapi.metmuseum.org/public/collection/v1/"

class RetrofitHelper(context: Context) {

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val client = OkHttpClient.Builder()
//        .addInterceptor(ChuckerInterceptor(context))
        .build()
}
