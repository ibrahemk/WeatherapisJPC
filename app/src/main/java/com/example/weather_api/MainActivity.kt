package com.example.weather_api

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity

import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge


import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.weather_api.Screens.SetupNavGraph

import com.example.weather_api.modules.home_module


import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

import org.koin.core.context.GlobalContext.startKoin


class MainActivity : ComponentActivity() {

    lateinit var navControaller: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)







        startKoin {
            androidLogger()
            androidContext(androidContext = this@MainActivity)
            modules(home_module)
        }
        enableEdgeToEdge()
        setContent {



                navControaller= rememberNavController()
                SetupNavGraph(navController = navControaller)


        }
    }





}




