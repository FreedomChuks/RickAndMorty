package com.wisetest.data.repository

import com.wisetest.data.datasource.cache.CacheDataSource
import com.wisetest.data.datasource.network.NetworkDataSource
import com.wisetest.data.mapper.toCharacter
import com.wisetest.data.mapper.toEntity
import com.wisetest.utils.ResultState
import kotlinx.coroutines.flow.flow

class CharacterRepository(
    private val networkDataSource: NetworkDataSource,
    private val cacheDataSource: CacheDataSource
) {
     fun fetchCharacter()= flow{

        emit(ResultState.Loading())
        //fetch from network
        val response = networkDataSource.fetchCharacters().data?.results

         //cache data
         response?.let { characterData->
             characterData.map { character->
                 cacheDataSource.insertAndReplaceCharacters(character.toEntity())
             }
         }
//        response?.map { character->
//            cacheDataSource.insertAndReplaceCharacters(character.toEntity())
//        }

        //emit from cache
        val cache = cacheDataSource.getCharacters().map { it.toCharacter() }

        emit(ResultState.Success(cache))

    }
}