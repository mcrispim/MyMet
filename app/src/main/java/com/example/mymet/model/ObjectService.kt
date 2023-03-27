package com.example.mymet.model

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class ObjectIdList(
    @SerializedName("total")
    val total: Int,
    @SerializedName("objectIds")
    val objectIds: List<Int>
)

interface ObjectApi {
//    @GET("users/{user}/repos")
//    fun listRepos(@Path("user") user: String?): Call<List<Repo?>?>?

    @GET("objects")
    fun fetchObjectIds(): Response<ObjectIdList>
}

class ObjectService {
    private val api: ObjectApi = Retrofit.Builder()
        .baseUrl("https://collectionapi.metmuseum.org/public/collection/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ObjectApi::class.java)

    suspend fun fetchObjectIds(): Response<ObjectIdList> = api.fetchObjectIds()
}

