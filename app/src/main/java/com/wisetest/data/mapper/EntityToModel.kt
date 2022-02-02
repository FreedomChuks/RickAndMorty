package com.wisetest.data.mapper
import com.wisetest.domain.Character
import com.wisetest.data.network.dto.Location
import com.wisetest.data.cache.entities.CharacterEntity
import com.wisetest.data.cache.entities.LocationEntity

/** Map Entity  to Dto **/
internal fun CharacterEntity.toCharacter() = Character(
    id=id,
    name = name,
    status=status,
    species=species,
    type=type,
    gender=gender,
    location = Location.map(),
    image = image
)

fun LocationEntity.map() = Location(locationName)