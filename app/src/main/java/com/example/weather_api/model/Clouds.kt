package com.example.weather_api.model


import com.google.gson.annotations.SerializedName

data class Clouds(
    @SerializedName("all")
    var all: Int = 0
)