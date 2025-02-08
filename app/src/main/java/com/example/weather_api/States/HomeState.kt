package com.example.weather_api.States

import com.example.weather_api.State
import com.example.weather_api.model.SingleWeather


data class HomeState(val isloadinfg:Boolean,val temp:SingleWeather?,val dataList: MutableList<String>):State{
    companion object{
        val intial:HomeState= HomeState(isloadinfg = true, temp = null , emptyList<String>().toMutableList())
    }
}
