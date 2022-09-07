package com.vishtech.sepiapetsapp.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.vishtech.sepiapetsapp.R
import com.vishtech.sepiapetsapp.ui.adapter.PetAdapter
import com.vishtech.sepiapetsapp.ui.viewmodel.MainActivityViewModel

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(){

    private val viewModel: MainActivityViewModel by viewModels()

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val petAdapter = PetAdapter(object: OnClickHandler{
            override fun onClick(url: String) {
                val intent = Intent(this@MainActivity, DetailScreen::class.java)
                intent.putExtra("url", url)
                startActivity(intent)
            }
        })

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = petAdapter

        viewModel.petList.observe(this){ petlist->
            petlist.pets.let { pets->
                petAdapter.petList = pets
                petAdapter.notifyDataSetChanged()
            }
        }
    }
}

interface OnClickHandler {
    fun onClick(url: String)
}