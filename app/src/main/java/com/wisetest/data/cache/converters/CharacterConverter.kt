package com.wisetest.data.cache.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.wisetest.data.cache.entities.CharacterEntity

@Deprecated("Not in Use")
class CharacterConverter {
    private val gson = Gson()

    @TypeConverter
    fun from(castItemEntities: List<CharacterEntity>): String? {
        if (castItemEntities.isNullOrEmpty()) return null

        val type = object : TypeToken<List<CharacterEntity>>() {}.type
        return gson.toJson(castItemEntities, type)
    }

    @TypeConverter
    fun to(castItemEntitiesString: String?): List<CharacterEntity>? {
        if (castItemEntitiesString.isNullOrEmpty()) return null

        val type = object : TypeToken<List<CharacterEntity>>() {}.type
        return gson.fromJson(castItemEntitiesString, type)
    }

}