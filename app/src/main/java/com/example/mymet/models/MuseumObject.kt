package com.example.mymet.models

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mymet.R

@Entity(tableName = "object")
data class MuseumObject(
    @PrimaryKey
    val objectID: Int,
    val primaryImage: String,
    val primaryImageSmall: String,
    val department: String,
    val objectName: String,
    val objectTitle: String,
    val artistName: String,
    val objectDate: String
) {
    companion object {

        @JvmStatic
        @BindingAdapter("android:src")
        fun loadImage(view: ImageView, imageUrl: String) {
            Glide.with(view.context)
                .load(imageUrl)
 //               .apply(RequestOptions().error(R.drawable.no_image))
                .into(view)
        }
    }
}

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