package com.example.mymet.data.model

data class MuseumObject(
    val objectID: Int,
    val primaryImage: String,
    val primaryImageSmall: String,
    val department: String,
    val objectName: String,
    val objectTitle: String,
    val artistName: String,
    val objectDate: String
)

val myObjects = mutableListOf(
    MuseumObject(
        45734,
        "https://images.metmuseum.org/CRDImages/as/original/DP251139.jpg",
        "https://images.metmuseum.org/CRDImages/as/web-large/DP251139.jpg",
        "Asian Art",
        "Hanging scroll",
        "Quail and Millet",
        "Kiyohara Yukinobu",
        "late 17th century",
    )
)