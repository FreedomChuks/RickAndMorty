package com.wisetest.data.cache.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.wisetest.data.cache.entities.CharacterDataEntity

class CharacterConverter {
    private val gson = Gson()

    @TypeConverter
    fun from(castItemEntities: List<CharacterDataEntity>): String? {
        if (castItemEntities.isNullOrEmpty()) return null

        val type = object : TypeToken<List<CharacterDataEntity>>() {}.type
        return gson.toJson(castItemEntities, type)
    }

    @TypeConverter
    fun to(castItemEntitiesString: String?): List<CharacterDataEntity>? {
        if (castItemEntitiesString.isNullOrEmpty()) return null

        val type = object : TypeToken<List<CharacterDataEntity>>() {}.type
        return gson.fromJson(castItemEntitiesString, type)
    }

}