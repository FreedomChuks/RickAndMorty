package com.wisetest.data.network.dto

import java.io.Serializable


data class CharacterDto (
    val pages:Int,
    val results:List<CharacterData>
):Serializable

data class CharacterData(
    val id:Int,
    val name:String,
    val status:String,
    val species:String,
    val type:String,
    val gender:String,
    val location: Location,
    val image:String,
):Serializable

data class Location(
    val name: String
):Serializable