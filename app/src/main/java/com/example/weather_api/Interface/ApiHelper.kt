package com.example.weather_api.Interface

import com.example.weather_api.model.Resource
import com.example.weather_api.model.SingleWeather
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response


interface ApiHelper {
   suspend  fun Get(url:String): Flow<Resource<SingleWeather>>
}