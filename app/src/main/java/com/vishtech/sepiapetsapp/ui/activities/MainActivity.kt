package com.vishtech.sepiapetsapp.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.vishtech.sepiapetsapp.R
import com.vishtech.sepiapetsapp.ui.adapter.PetAdapter
import com.vishtech.sepiapetsapp.ui.viewmodel.MainActivityViewModel
import com.vishtech.sepiapetsapp.utils.WorkUtil

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(){

    private val viewModel: MainActivityViewModel by viewModels()

    private lateinit var recyclerView: RecyclerView

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val workingHours = viewModel.getWorkTime()

        if(!WorkUtil.isValidWorkingTime(workingHours)) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Sepia's Pet shop is closed")
            builder.setMessage("Please come back on work hours\n$workingHours")
            builder.setPositiveButton("Ok") { _, _ ->
                finish()
            }
            builder.show()
        }

        Log.d(TAG, "onCreate: "+WorkUtil.isValidWorkingTime(workingHours))
        Log.d(TAG, "onCreate: "+viewModel.getWorkTime())
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