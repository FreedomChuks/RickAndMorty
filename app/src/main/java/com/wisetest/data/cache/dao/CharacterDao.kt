package com.wisetest.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wisetest.data.cache.entities.CharacterEntity


@Dao
interface CharacterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(characterEntity: CharacterEntity)

    @Query("SELECT * FROM Character_Table")
    suspend fun fetchAllCharacter(): List<CharacterEntity>

    @Query("DELETE FROM Character_Table")
    suspend fun deleteAllCharacters()

}