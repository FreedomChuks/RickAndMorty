package com.wisetest.data.datasource

import com.rommansabbir.networkx.core.NetworkXCore
import com.wisetest.data.cache.AppDatabase
import com.wisetest.data.mapper.toDto
import com.wisetest.data.mapper.toEntity
import com.wisetest.data.network.dto.CharacterDto
import com.wisetest.data.cache.entities.CharacterEntity
import com.wisetest.data.network.ApiService
import com.wisetest.utils.ResultState
import com.wisetest.utils.SafeApiRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class CharacterDataSource @Inject constructor(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase
):SafeApiRequest() {

    private suspend fun saveCharacterToDb(characterEntity: CharacterEntity)
            = appDatabase.CharacterDao().insertCharacter(characterEntity)

    suspend fun getCharacter():Flow<ResultState<CharacterDto>>{
        /** an instance of characterDao **/
        val getCharacterCache = appDatabase.CharacterDao().fetchAllCharacter()

        return if (isNetworkConnected()){
            Timber.i("internet is On")
            val resultData = safeApiCall(
                call = {apiService.fetchCharacters()},
                successCallback = { it?.toEntity()?.let { data -> saveCharacterToDb(data) } }
            )
            /** return networkSource Flow**/
            flow {
                emit(ResultState.Loading()) // emit loading state
                emit(resultData)
            }

        }else{
            Timber.i("internet is not on")
            /** return cacheSource Flow**/

            flow {
                emit(ResultState.Loading()) // emit loading state
                emit(ResultState.Success(getCharacterCache.toDto()))
            }
        }

    }

    private fun isNetworkConnected():Boolean {
        NetworkXCore.getNetworkX().isInternetConnected().let {
            return when(it){
                true-> true
                false-> false
            }
        }
    }

}

