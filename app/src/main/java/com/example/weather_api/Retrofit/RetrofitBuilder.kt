package com.example.weather_api.Retrofit

import com.example.weather_api.Interface.ApiService
import com.example.weather_api.Utils.Global
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitBuilder {




    private fun getRetrofit(): Retrofit {


        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().connectTimeout(100, TimeUnit.SECONDS)
            .readTimeout(100, TimeUnit.SECONDS).addInterceptor(interceptor).build()
        return Retrofit.Builder()
            .baseUrl(Global.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

     val apiService: ApiService = getRetrofit().create(ApiService::class.java)

}