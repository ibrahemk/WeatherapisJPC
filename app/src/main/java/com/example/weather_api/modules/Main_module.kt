package com.example.weather_api.modules

import com.example.weather_api.Interface.ApiService
import com.example.weather_api.Retrofit.ApiHelperImpl
import com.example.weather_api.Retrofit.RetrofitBuilder
import com.example.weather_api.ViewModel.Home_model
import com.example.weather_api.reducer.HomeReducer
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf

import org.koin.dsl.module

val home_module= module {

    viewModelOf(::Home_model)
    factoryOf(::HomeReducer)
    singleOf(::RetrofitBuilder)
    factory { ApiHelperImpl(get()) }

}