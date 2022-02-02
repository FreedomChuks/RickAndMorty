package com.wisetest.data.datasource.cache

interface CacheDataSourceContract {
    fun insertCharacters()
    fun deleteCharacter()
    fun getCharacters()
}