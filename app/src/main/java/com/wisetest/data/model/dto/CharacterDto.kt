package com.wisetest.data.model.dto

import org.w3c.dom.CharacterData

data class CharacterDto (
    val results:List<CharacterData>
)

data class CharacterData(
val id:String,
val name:String,
val status:String,
val species:String,
val type:String,
val gender:String,
val location:Location,
val image:String,
)

data class Location(
    val name: String
)