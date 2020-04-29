package com.mithuroy.expoyapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val simpleModels = getSimpleData()
        recyclerView.apply {
            adapter = SimpleAdapter(simpleModels)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}