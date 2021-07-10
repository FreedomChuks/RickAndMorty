package com.wisetest.utils

import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response

abstract class SafeApiRequest {
    suspend fun <T:Any>safeApiCall(call:suspend ()-> Response<T>,successCallback:suspend (T?)->Unit):ResultState<T>{
        val response = call.invoke()
        return if (response.isSuccessful){
            successCallback.invoke(response.body())
            ResultState.Success(response.body()!!)
        }else{
            val responseErr = response.errorBody()?.string()
            val message = StringBuilder()
            responseErr?.let {
                try {
                    message.append(JSONObject(it).getString("error"))
                    ResultState.Error(JSONObject(it).getString("error"))
                } catch (e: JSONException) {
                    ResultState.Error<String>(e.message)
                }
            }
            throw ApiException(message.toString())
        }
    }
}