package com.example.weather_api.Retrofit

import androidx.collection.emptyIntIntMap
import com.example.weather_api.Interface.ApiHelper
import com.example.weather_api.Interface.ApiService
import com.example.weather_api.model.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException


class ApiHelperImpl( val retrofitBuilder: RetrofitBuilder) : ApiHelper,BaseRepo() {


    //    suspend fun <T: Any> handleRequest(requestFunc: suspend () -> T): kotlin.Result<T> {
//        return try {
//            Result.success(requestFunc.invoke())
//        } catch (he: HttpException) {
//            Result.failure(he)
//        }
//    }
    override suspend fun Get(url: String) = flow {
//        "MTIzNC0xMjM0="
        emit(safeApiCall { retrofitBuilder.apiService.Get( url) })
    }


}