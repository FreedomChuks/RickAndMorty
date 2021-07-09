package com.wisetest.data.datasource

import com.wisetest.data.cache.dao.CharacterDao
import com.wisetest.data.model.dto.CharacterData
import com.wisetest.data.model.entity.CharacterEntity
import com.wisetest.data.network.ApiService
import com.wisetest.utils.SafeApiCall
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterDataSource @Inject constructor(
    private val apiService: ApiService,
    private val appDatabase: CharacterDao
):SafeApiCall() {

    private suspend fun saveCharacterToDb(characterEntity: CharacterEntity)
            = appDatabase.insertCharacter(characterEntity)

    suspend fun getCharacter():Flow<CharacterData>{
        val getCharacterCache = appDatabase.fetchAllCharacter()
    }
}
