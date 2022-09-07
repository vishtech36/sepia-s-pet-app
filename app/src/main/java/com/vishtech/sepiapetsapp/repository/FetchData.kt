package com.vishtech.sepiapetsapp.repository

import android.app.Application
import com.google.gson.Gson
import com.vishtech.sepiapetsapp.R
import com.vishtech.sepiapetsapp.model.PetList

class FetchData(val application: Application) {
    private val gson = Gson()

    fun getPetList(): PetList {
        val response = application.resources.openRawResource(R.raw.pets_list)
            .bufferedReader().use { it.readText() }
        return gson.fromJson(response, PetList::class.java);
    }
}