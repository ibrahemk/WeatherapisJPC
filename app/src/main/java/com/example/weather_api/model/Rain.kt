package com.example.weather_api.model


import com.google.gson.annotations.SerializedName

data class Rain(
    @SerializedName("1h")
    var h: Double = 0.0
)