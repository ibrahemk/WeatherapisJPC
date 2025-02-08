package com.example.weather_api.Interface



import com.example.weather_api.model.SingleWeather
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Url

interface ApiService {

    @GET
    suspend fun Get(@Url url:String):Response<SingleWeather>
}