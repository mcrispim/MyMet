package com.example.mymet.network

import com.example.mymet.models.MuseumObject
import com.example.mymet.models.MuseumObjectIdList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ObjectService {
//    @GET("users/{user}/repos")
//    fun listRepos(@Path("user") user: String?): Call<List<Repo?>?>?

    @GET("objects")
    suspend fun getObjectIds(): Response<MuseumObjectIdList>

    @GET("/public/collection/v1/objects/{objectId}")
    suspend fun getObjectById(@Path("objectId") objectId: Int): Response<MuseumObject>

}
