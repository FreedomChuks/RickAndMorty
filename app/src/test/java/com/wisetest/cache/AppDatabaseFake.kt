package com.wisetest.cache

import com.wisetest.data.cache.entities.CharacterEntity

class AppDatabaseFake {
    //Fake db table
    val character = mutableListOf<CharacterEntity>()
}