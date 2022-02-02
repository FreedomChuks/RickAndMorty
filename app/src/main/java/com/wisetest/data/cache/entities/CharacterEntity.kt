package com.wisetest.data.cache.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.wisetest.utils.Constant.CHARACTER_DATA_TABLE
import com.wisetest.utils.Constant.CHARACTER_TABLE

@Entity(tableName = CHARACTER_TABLE)
data class CharacterEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "Id") val id: Int,
    @ColumnInfo(name = "Name") val name:String,
    @ColumnInfo(name = "Status") val status:String,
    @ColumnInfo(name = "Species") val species:String,
    @ColumnInfo(name = "Type") val type:String,
    @ColumnInfo(name = "Gender") val gender:String,
    @Embedded
    val Location: LocationEntity,
    @ColumnInfo(name = "Image") val image:String,
)

data class LocationEntity(
    val locationName: String
)


