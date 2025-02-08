package com.example.weather_api



sealed class ApiResult <out T> ( val status: ApiStatus,val data: T?, val message:String?) {

    data class Success<out R>(val _data: R?): ApiResult<R>(
        status = ApiStatus.SUCCESS,
        data = _data,
        message = null
    )

    data class Error(val exception: String): ApiResult<Nothing>(
        status = ApiStatus.ERROR,
        data = null,
        message = exception
    )


    enum class ApiStatus {
        /**
         * Indicates that the task has not been executed yet.
         */
        ERROR,

        /**
         * Indicates that the task is running.
         */
        SUCCESS,


    }
}