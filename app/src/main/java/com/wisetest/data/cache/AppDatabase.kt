package com.wisetest.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wisetest.data.cache.dao.CharacterDao
import com.wisetest.data.model.entity.CharacterEntity

@Database(
    entities = [CharacterEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase:RoomDatabase() {
    abstract fun CharacterDao() :CharacterDao
}