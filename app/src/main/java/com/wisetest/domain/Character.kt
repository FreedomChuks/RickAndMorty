package com.wisetest.domain

import com.wisetest.data.network.dto.Location
import java.io.Serializable

data class Character(
    val id:Int,
    val name:String,
    val status:String,
    val species:String,
    val type:String,
    val gender:String,
    val location: Location,
    val image:String,
):Serializable