package com.wisetest.utils
/** Data StateClass that represent Network Response State
 * **/
sealed class ResultState<T>(
    val data:T?=null,
    val error:String?=null
){
    class Empty<T>:ResultState<T>()
    class Loading<T> : ResultState<T>()
    class Success<T>(data: T?):ResultState<T>(data = data)
    class Error<T>(error: String?):ResultState<T>(error = error)
}
