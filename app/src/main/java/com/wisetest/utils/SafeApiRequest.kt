package com.wisetest.utils

import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response

abstract class SafeApiRequest {
    suspend fun <T : Any> safeApiCall(
        call: suspend () -> Response<T>,
        successCallback: suspend (T?) -> Unit
    ): ResultState<T> {
        return try {
            val response = call.invoke()
            return if (response.isSuccessful) {
                successCallback.invoke(response.body())
                ResultState.Success(response.body()!!)
            } else {
                val responseErr = response.errorBody()?.toString()
                val message = StringBuilder()
                ResultState.Error(responseErr)
            }
        } catch (e: Exception) {
            ResultState.Error(e.message)
        }
    }
}

