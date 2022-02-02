package com.wisetest.data.datasource.network

import com.wisetest.data.network.ApiService
import com.wisetest.data.network.dto.CharacterDto
import com.wisetest.utils.ResultState
import com.wisetest.utils.SafeApiRequest
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class NetworkDataSource @Inject constructor(private val apiService: ApiService): SafeApiRequest() {

    suspend fun fetchCharacters():ResultState<CharacterDto>{
        return safeApiCall(
            call = { apiService.fetchCharacters()},
            successCallback = {}
        )
    }
}