package com.wisetest.data.model.dto


data class CharacterDto (
    val pages:Int,
    val results:List<CharacterData>
)

data class CharacterData(
    val id:Int,
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