package com.wisetest.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.wisetest.data.cache.converters.CharacterConverter
import com.wisetest.data.cache.dao.CharacterDao
import com.wisetest.data.cache.entities.CharacterEntity

@Database(
    entities = [CharacterEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    CharacterConverter::class
)
abstract class AppDatabase:RoomDatabase() {
    abstract fun CharacterDao() :CharacterDao
}