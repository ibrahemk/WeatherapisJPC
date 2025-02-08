package com.example.weather_api.Event

import com.example.weather_api.Action
import com.example.weather_api.model.SingleWeather

sealed interface HomeIntent:Action {
   data class isloading(val showloading:Boolean):HomeIntent
    data class showTemp(val temp:SingleWeather):HomeIntent


}