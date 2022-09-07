package com.vishtech.sepiapetsapp.model

import com.google.gson.annotations.SerializedName

data class Pet(
    @SerializedName("image_url")
    val imageUrl: String,
    val title: String,
    @SerializedName("content_url")
    val contentUrl: String,
    @SerializedName("date_added")
    val dateAdded: String
)