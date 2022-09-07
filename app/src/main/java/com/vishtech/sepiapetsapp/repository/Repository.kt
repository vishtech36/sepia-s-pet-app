package com.vishtech.sepiapetsapp.repository

import android.app.Application
import com.vishtech.sepiapetsapp.model.PetList

class Repository(application: Application) {

    private val fetchData = FetchData(application)

     fun getPetListData(): PetList {
        return fetchData.getPetList();
    }
}