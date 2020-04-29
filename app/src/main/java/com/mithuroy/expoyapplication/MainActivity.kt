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

        recyclerView.withModels {
            simpleModels.forEachIndexed { index, data ->
                when(data.type) {
                    "Header" -> header {
                        id(index)
                        headerContent("Pos: $index ${data.content}")
                    }
                    "Content" -> content {
                        id(index)
                        simpleModel(data)
                    }
                    "Footer" -> footer {
                        id(index)
                        footerContent("#$index ${data.content}")
                    }
                }
            }
        }
    }
}