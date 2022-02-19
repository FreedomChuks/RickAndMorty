package com.wisetest.data.datasource

import com.wisetest.data.cache.AppDatabase
import com.wisetest.data.network.ApiService
import com.wisetest.utils.SafeApiRequest
import javax.inject.Inject

@Deprecated("No More in Use")
class CharacterDataSource @Inject constructor(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase
):SafeApiRequest() {
//SafeApiRequest
//    private suspend fun saveCharacterToDb(characterEntity: CharacterEntity)
//            = appDatabase.CharacterDao().insertCharacter(characterEntity)
//
//    suspend fun getCharacter():Flow<ResultState<CharacterDto>>{
//        /** an instance of characterDao **/
//        val getCharacterCache = appDatabase.CharacterDao().fetchAllCharacter()
//
//        return if (isNetworkConnected()){
//            Timber.i("internet is On")
//            val resultData = safeApiCall(
//                call = {apiService.fetchCharacters()},
//                successCallback = { it?.toEntity()?.let { data -> saveCharacterToDb(data) } }
//            )
//            /** return networkSource Flow**/
//            flow {
//                emit(ResultState.Loading()) // emit loading state
//                emit(resultData)
//            }
//
//        }else{
//            Timber.i("internet is not on")
//            /** return cacheSource Flow**/
//
//            flow {
//                emit(ResultState.Loading()) // emit loading state
//                emit(ResultState.Success(getCharacterCache.toDto()))
//            }
//        }
//
//    }
//
//    private fun isNetworkConnected():Boolean {
//        NetworkXCore.getNetworkX().isInternetConnected().let {
//            return when(it){
//                true-> true
//                false-> false
//            }
//        }
//    }

}

