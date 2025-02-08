package com.example.weather_api.Screens

import android.content.ClipData.Item
import android.content.Context
import android.location.Location
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.weather_api.MainActivity
import com.example.weather_api.R
import com.example.weather_api.Utils.Global
import com.example.weather_api.ViewModel.Home_model
import com.example.weather_api.modules.home_module


import org.koin.androidx.compose.koinViewModel
import org.koin.compose.KoinApplication

@Composable
fun Home_screen(
    navController: NavHostController,
    homemodel: Home_model = koinViewModel()
) {




homemodel.IsLocationPermissionGranted(LocalContext.current)




    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold{ padding ->
            if (!homemodel.state.isloadinfg) {



                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                            .fillMaxSize()
                            .padding(padding)
                    ) {

                            Column (
                                modifier = Modifier
                                    .padding(padding)
                                    .background(Color.White)
                                    .fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally,verticalArrangement = Arrangement.Center

                            ) {

                                Text(text = "Temp:${homemodel.state.temp!!.main.temp.toInt()}℃\nFeels like:${homemodel.state.temp!!.main.feelsLike.toInt()}℃", fontSize = 24.sp,
                                    modifier = Modifier
                                        .padding(padding)
                                       )

                                AsyncImage(
                                    model = "${Global.WeatherImage}${homemodel.state.temp!!.weather[0].icon}.png" ,
                                    error = painterResource(id = R.drawable.ic_launcher_background),
                                    placeholder = painterResource(id = R.drawable.ic_launcher_background),
                                    contentDescription = "Sample image",
                                    modifier = Modifier.size(124.dp)
                                )
                            }





                    }


            }
            else {

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.clickable {

                            },
                            color = Color.Green
                        )
                    }

            }
        }

    }


}


@Preview( showBackground = true)
@Composable
private fun PreviewHome_screen() {
    KoinApplication(
        application = { modules(home_module) },
        content = {     Home_screen(navController = NavHostController(LocalContext.current))}
    )

}