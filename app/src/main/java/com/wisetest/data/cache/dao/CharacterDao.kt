package com.wisetest.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wisetest.data.model.entity.CharacterEntity


@Dao
interface CharacterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(characterEntity: CharacterEntity)


    @Query("SELECT * FROM Character_Table")
    suspend fun fetchAllCharacter():CharacterEntity

}