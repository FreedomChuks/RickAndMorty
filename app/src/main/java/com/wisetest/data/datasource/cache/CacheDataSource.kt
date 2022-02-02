package com.wisetest.data.datasource.cache

import com.wisetest.data.cache.dao.CharacterDao
import com.wisetest.data.cache.entities.CharacterEntity
import javax.inject.Inject

class CacheDataSource @Inject constructor(
    private val appDatabase: CharacterDao,
    ):CacheDataSourceContract{

    override suspend fun insertAndReplaceCharacters(character: CharacterEntity) {
     appDatabase.insertCharacter(character)
    }

    override suspend fun deleteCharacters() {
        appDatabase.deleteAllCharacters()
    }

    override suspend fun getCharacters(): List<CharacterEntity> {
        return appDatabase.fetchAllCharacter()
    }


}