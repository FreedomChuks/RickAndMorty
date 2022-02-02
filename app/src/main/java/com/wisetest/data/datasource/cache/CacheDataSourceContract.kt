package com.wisetest.data.datasource.cache

import com.wisetest.data.cache.entities.CharacterEntity

interface CacheDataSourceContract {
    suspend fun insertAndReplaceCharacters(character:CharacterEntity)
    suspend fun deleteCharacters()
    suspend fun getCharacters():List<CharacterEntity>
}