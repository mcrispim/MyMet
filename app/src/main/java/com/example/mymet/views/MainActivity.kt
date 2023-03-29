package com.example.mymet.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymet.Application
import com.example.mymet.databinding.ActivityMainBinding
import com.example.mymet.objectsAdapter.ObjectAdapter

const val NUMBER_OF_OBJECTS = 10

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //private lateinit var museumObjectViewModel: MuseumObjectViewModel
    private lateinit var adapter: ObjectAdapter

    val museumObjectList = Application.
        //.museumObjectRepository.getObjects(NUMBER_OF_OBJECTS)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvObjects.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = ObjectAdapter(museumObjectList)
        }

    }
}
