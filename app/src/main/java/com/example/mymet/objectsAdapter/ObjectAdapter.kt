package com.example.mymet.objectsAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymet.R
import com.example.mymet.data.model.MuseumObject
import com.example.mymet.data.model.myObjects

class ObjectAdapter(private val objects: MutableList<MuseumObject> = myObjects) :
    RecyclerView.Adapter<ObjectAdapter.ObjectViewHolder>() {

    class ObjectViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var objectname: TextView = view.findViewById(R.id.objectName)
        var objectTitle: TextView = view.findViewById(R.id.objectTitle)
        var artistName: TextView = view.findViewById(R.id.artistName)
        var objectDate: TextView = view.findViewById(R.id.objectDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObjectViewHolder {
        val objectView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_object, parent, false)
        return ObjectViewHolder(objectView)
    }

    override fun getItemCount() = objects.size

    override fun onBindViewHolder(holder: ObjectViewHolder, position: Int) {
        val museumObject = objects[position]
        holder.objectname.text = museumObject.objectName
        holder.objectTitle.text = museumObject.objectTitle
        holder.artistName.text = museumObject.artistName
        holder.objectDate.text = museumObject.objectDate
    }
}

