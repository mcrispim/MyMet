package com.example.mymet

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymet.data.model.ObjectService
import com.example.mymet.databinding.ActivityMainBinding
import com.example.mymet.data.model.ObjectViewModel
import com.example.mymet.data.model.ViewModelFactory
import com.example.mymet.data.model.myObjects
import com.example.mymet.objectsAdapter.ObjectAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var objectViewModel: ObjectViewModel
    private lateinit var adapter: ObjectAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvObjects.layoutManager = LinearLayoutManager(applicationContext)

        val objectRepository = (application as Application).objectsRepository
        objectViewModel = ViewModelProvider(this, ViewModelFactory(objectRepository))[ObjectViewModel::class.java]


        objectViewModel.objectIds.observe(this) { charList ->
            charList.let { charList ->
                adapter = CharAdapter(this, charList,
                    CharAdapter.OnClickListener { char ->
                        val mIntent = Intent(this, DetailActivity::class.java)
                        val mBundle = Bundle()
                        mBundle.putString("name", char.name)
                        mBundle.putString("gender", char.gender)
                        mBundle.putString("species", char.species)
                        mBundle.putString("status", char.status)
                        mBundle.putString("location", char.location.name)
                        mBundle.putString("origin", char.origin.name)
                        mBundle.putString("image", char.image)
                        mIntent.putExtras(mBundle)
                        startActivity(mIntent)
                    }
                )
                binding.rvChars.adapter = adapter
                adapter.notifyDataSetChanged()
            }
        }


    }
}
