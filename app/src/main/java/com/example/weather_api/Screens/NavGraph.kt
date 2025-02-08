package com.example.weather_api.Screens

import android.telecom.Call
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(navController = navController,
        startDestination = Screens.Home
    ){
        composable<Screens.Home>{
            Home_screen(navController)
        }



    }

}