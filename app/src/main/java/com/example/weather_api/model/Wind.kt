package com.example.weather_api.model


import com.google.gson.annotations.SerializedName

data class Wind(
    @SerializedName("deg")
    var deg: Int = 0,
    @SerializedName("gust")
    var gust: Double = 0.0,
    @SerializedName("speed")
    var speed: Double = 0.0
)