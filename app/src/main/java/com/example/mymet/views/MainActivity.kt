package com.example.mymet.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymet.databinding.ActivityMainBinding
import com.example.mymet.viewmodel.MuseumObjectViewModel
import com.example.mymet.models.ViewModelFactory
import com.example.mymet.objectsAdapter.ObjectAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var museumObjectViewModel: MuseumObjectViewModel
    private lateinit var adapter: ObjectAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvObjects.layoutManager = LinearLayoutManager(applicationContext)

        val museumObjectRepository = (application as com.example.mymet.Application).museumObjectRepository
        museumObjectViewModel = ViewModelProvider(
            this,
            ViewModelFactory(museumObjectRepository)
        )[MuseumObjectViewModel::class.java]

        museumObjectViewModel.objectIds.observe(this) { charList ->
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
