package com.wisetest.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wisetest.data.cache.dao.CharacterDao

@Database(
    entities = [CharacterDao::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase:RoomDatabase() {
    abstract class Character() :CharacterDao
}