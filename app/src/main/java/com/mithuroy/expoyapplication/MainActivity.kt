package com.mithuroy.expoyapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val simpleModels = getSimpleData()
        populateList(simpleModels)

    }

    private fun populateList(simpleModels: MutableList<SimpleModel>) {
        recyclerView.withModels {
            simpleModels.forEachIndexed { position, model ->
                when (model.type) {
                    "Header" -> header {
                        id(position)
                        headerContent("Pos:$position ${model.content}")
                    }
                    "Content" -> content {
                        id(position)
                        simpleModel(model)
                        onClickContent { _ ->
                            Toast.makeText(this@MainActivity, model.content, Toast.LENGTH_SHORT).show()
                            simpleModels.removeAt(position)
                            populateList(simpleModels)
                        }
                    }
                    "Footer" -> footer {
                        id(position)
                        footerContent("$position ${model.content}")
                    }
                }
            }
        }
    }
}