package com.wisetest.data.network

import com.wisetest.data.model.dto.CharacterDto
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    /** Api request to fetch characters from rick&morty api**/
    @GET("character")
    fun fetchCharacters():Response<CharacterDto>
}