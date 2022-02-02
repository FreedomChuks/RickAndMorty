package com.wisetest.data.mapper

import com.wisetest.data.network.dto.CharacterData
import com.wisetest.data.network.dto.CharacterDto
import com.wisetest.data.network.dto.Location
import com.wisetest.data.cache.entities.CharacterEntity
import com.wisetest.data.cache.entities.LocationEntity

/** Map Dto to Entity **/
internal fun CharacterData.toEntity() = CharacterEntity(
    id=id,
    name = name,
    status=status,
    species=species,
    type=type,
    gender=gender,
    Location = location.map(),
    image = image
)

fun Location.map() = LocationEntity(name)

