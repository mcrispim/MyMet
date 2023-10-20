package com.example.mymet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mymet.view.SimpleAdapter
import com.example.mymet.view.SimpleItem

class SimpleListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_list)

        val recyclerView: RecyclerView = findViewById(R.id.rvWorks)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val itemList = listOf(
            SimpleItem("Item 1"),
            SimpleItem("Item 2"),
            SimpleItem("Item 3")
        )

        val adapter = SimpleAdapter(itemList)
        recyclerView.adapter = adapter
    }
}
