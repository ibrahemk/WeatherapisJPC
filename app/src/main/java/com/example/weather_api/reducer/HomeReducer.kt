package com.example.weather_api.reducer

import com.example.weather_api.Event.HomeIntent
import com.example.weather_api.Reducer
import com.example.weather_api.States.HomeState

class HomeReducer: Reducer<HomeState, HomeIntent>  {
    override fun reduce(state: HomeState, action: HomeIntent): HomeState {
        return when(action){
           is HomeIntent.isloading->state.copy(isloadinfg = action.showloading)
         is HomeIntent.showTemp->state.copy(isloadinfg = false, dataList = emptyList<String>().toMutableList(), temp = action.temp)

        }
    }
}