package com.example.weather_api.model

import com.google.gson.annotations.SerializedName

data class ErrorX(
    @SerializedName("cod")
    var cod: String? = null,
    @SerializedName("message")
    var message: String? = null
)