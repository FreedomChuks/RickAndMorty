package com.wisetest.cache

import com.wisetest.data.cache.dao.CharacterDao
import com.wisetest.data.model.entity.CharacterEntity

class CharacterDaoFake(
    private val db:AppDatabaseFake
):CharacterDao {

    override suspend fun insertCharacter(characterEntity: CharacterEntity) {
       db.character.add(characterEntity)
    }

    override suspend fun fetchAllCharacter(): CharacterEntity {
        return db.character[0]
    }
}