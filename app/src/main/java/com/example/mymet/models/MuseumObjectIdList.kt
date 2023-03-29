package com.example.mymet.models

import com.google.gson.annotations.SerializedName

data class MuseumObjectIdList(
    @SerializedName("total")
    val total: Int,
    @SerializedName("objectIds")
    val objectIds: List<Int>
)

