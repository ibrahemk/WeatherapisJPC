package com.example.weather_api.ViewModel


import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.core.app.ActivityCompat
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.viewModelScope
import com.example.weather_api.Event.HomeIntent
import com.example.weather_api.MviViewModel
import com.example.weather_api.Retrofit.ApiHelperImpl
import com.example.weather_api.States.HomeState
import com.example.weather_api.Utils.Global
import com.example.weather_api.model.Resource
import com.example.weather_api.reducer.HomeReducer
import com.google.android.gms.location.CurrentLocationRequest
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationTokenSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch


class Home_model(reducer: HomeReducer,val apiHelper: ApiHelperImpl): MviViewModel<HomeState, HomeIntent> (reducer, HomeState.intial) {

init {

}
    // 4

    fun handle_loading(show:Boolean){
        dispatch(HomeIntent.isloading(show))
    }


    @Composable
    fun IsLocationPermissionGranted(context: Context) {
        if (context.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED
        ) {
           getlastKnownLocation(context)

        } else {
            Log.e("permission", "Permission is revoked")
            RequestPermissions(context = context,this)
        }
    }
    @Composable
    fun RequestPermissions(context: Context,homemodel: Home_model) {
        val locationPermissionRequest = rememberLauncherForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            when {
                permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                    // Precise location access granted.
                    getlastKnownLocation(context)

                }

                else -> {
                    // No location access granted.
                    homemodel.getdata(0.0,0.0)
                }
            }
        }

        // Before you perform the actual permission request, check whether your app
        // already has the permissions, and whether your app needs to show a permission
        // rationale dialog. For more details, see Request permissions:
        // https://developer.android.com/training/permissions/requesting#request-permission
        locationPermissionRequest.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        )
    }
     fun getlastKnownLocation(context: Context){
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
          if (ActivityCompat.checkSelfPermission(
                 context,
                 Manifest.permission.ACCESS_FINE_LOCATION
             ) == PackageManager.PERMISSION_GRANTED) {
//   fusedLocationClient.lastLocation.addOnSuccessListener { getdata(lat = it.latitude, lng = it.longitude) }.addOnFailureListener {getdata(0.0,0.0)}
//              val currentBuilder =
              fusedLocationClient.getCurrentLocation(CurrentLocationRequest.Builder().setDurationMillis(30000).build(),null)
                  .addOnSuccessListener { getdata(lat = it.latitude, lng = it.longitude) }.addOnFailureListener {getdata(0.0,0.0)}
//              fusedLocationClient.requestLocationUpdates(LocationRequest.Builder(60000L)
//                  .setPriority(Priority.PRIORITY_HIGH_ACCURACY)
//                  .build())

         }

    }
    fun getdata(lat:Double,lng: Double)=viewModelScope.launch {
        handle_loading(true)

//        31.238834,29.994946
            apiHelper.Get("${Global.Get_Single_weather}?lat=${lat}&lon=${lng}&units=metric&appid=${Global.ApiKey}").flowOn(Dispatchers.IO)
                .catch { e->
                }
                .collect{

when (it) {
    is Resource.Success -> {
        if (it.data != null) {
dispatch(HomeIntent.showTemp(it.data))
        }
    }

    is Resource.Error -> {}
}
//                    state.dataList.add(it)
                    handle_loading(false)

            }
        }

}