package com.vishtech.sepiapetsapp.repository

import android.app.Application
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.vishtech.sepiapetsapp.R
import com.vishtech.sepiapetsapp.model.PetList
import org.json.JSONObject

/*
*  @FetchData class help's to fetch required data
* */
class FetchData(private val application: Application) {

    private val gson = Gson()

    // Returns list of Pet from pets_list.json
    fun getPetList(): PetList {
        val response = application.resources.openRawResource(R.raw.pets_list)
            .bufferedReader().use { it.readText() }
        return gson.fromJson(response, PetList::class.java)
    }

    // Returns Work Time parsing from config.json
    fun getWorkTime(): String {
        val response = application.resources.openRawResource(R.raw.config)
            .bufferedReader().use { it.readText() }
        val jsonObject = JSONObject(response.substringAfter(" "))
        return jsonObject.getString("workHours")
    }
}