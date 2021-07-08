package com.wisetest.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.wisetest.utils.Constant.CHARACTER_TABLE

@Entity(tableName = CHARACTER_TABLE)
data class CharacterEntity (
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name:String,
    val status:String,
    val species:String,
    val type:String,
    val gender:String,
    val location:LocationEntity,
    val image:String,
)

data class LocationEntity(
    val name: String
)


