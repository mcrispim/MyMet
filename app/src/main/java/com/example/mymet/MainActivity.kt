package com.example.mymet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymet.databinding.ActivityMainBinding
import com.example.mymet.model.ObjectViewModel
import com.example.mymet.model.myObjects
import com.example.mymet.objectsAdapter.ObjectAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: ObjectViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(ObjectViewModel::class.java)

        viewModel.fetchObjectIds()

        val rvObjects = binding.rvObjects
        rvObjects.apply {
            adapter = ObjectAdapter()
            layoutManager = LinearLayoutManager(applicationContext)
        }
    }
}
