package com.wisetest.data.network

import com.wisetest.data.network.dto.CharacterDto
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    /** Api request to fetch characters from rick&morty api **/
    @GET("character")
    suspend fun fetchCharacters():Response<CharacterDto>
}