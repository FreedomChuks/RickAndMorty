package com.wisetest.data.datasource.network

import com.wisetest.data.network.dto.CharacterData
import com.wisetest.data.network.dto.CharacterDto
import com.wisetest.utils.ResultState
import kotlinx.coroutines.flow.Flow

interface NetworkDataSourceContract {
    suspend fun fetchCharacters():ResultState<CharacterDto>
}