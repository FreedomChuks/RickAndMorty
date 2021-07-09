package com.wisetest.utils

import com.google.gson.Gson
import retrofit2.Response
import timber.log.Timber

abstract class SafeApiCall {
    suspend fun <T>safeApiCall(call:suspend ()-> Response<T>):ResultState<T> {
        val response = call.invoke()
        return if (response.isSuccessful){
            ResultState.Success(response.body())
        }else{
            val errorResponse = response.errorBody()
            val deserialize = Gson().toJson(errorResponse)
            Timber.e("error response $deserialize")
            ResultState.Error(deserialize)
        }
    }
}