package com.example.mymet.data.model

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

data class ObjectIdList(
    @SerializedName("total")
    val total: Int,
    @SerializedName("objectIds")
    val objectIds: List<Int>
)

interface ObjectService {
//    @GET("users/{user}/repos")
//    fun listRepos(@Path("user") user: String?): Call<List<Repo?>?>?

    @GET("objects")
    suspend fun getObjectIds(): Response<ObjectIdList>

}
