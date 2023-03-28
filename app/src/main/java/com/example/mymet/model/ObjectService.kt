package com.example.mymet.model

import androidx.lifecycle.viewModelScope
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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
    suspend fun fetchObjectIds(): ObjectIdList
}

class ObjectService {
    private val api: ObjectApi = Retrofit.Builder()
        .baseUrl("https://collectionapi.metmuseum.org/public/collection/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ObjectApi::class.java)

    suspend fun fetchObjectIds(): ObjectIdList {
        CoroutineScope.launch(Dispatchers.IO) {
            val res = service.fetchObjectIds()

            if (res.isSuccessful) {
                withContext(Dispatchers.Main) {
                    objectIds = res.body()!!
                }
            }
        }

    } = api.fetchObjectIds()
}

