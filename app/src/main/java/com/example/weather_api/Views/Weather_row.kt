package com.example.weather_api.Views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.weather_api.R
import com.example.weather_api.Screens.Home_screen

@Composable
fun weather_row(item:String){
    OutlinedCard(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()) {
        Box(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {

            Text(text = item)
        }

    }
}
@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewHome_screen() {
weather_row(item = "Khalil")
}
