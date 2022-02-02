package com.wisetest.data.mapper

import com.wisetest.data.network.dto.CharacterData
import com.wisetest.data.network.dto.CharacterDto
import com.wisetest.data.network.dto.Location
import com.wisetest.data.cache.entities.CharacterDataEntity
import com.wisetest.data.cache.entities.CharacterEntity
import com.wisetest.data.cache.entities.LocationEntity

/** Map Dto to Entity **/
internal fun CharacterDto.toEntity() = CharacterEntity(
    id=pages,
    results = results.map { it.map() }
)

internal fun CharacterData.map() = CharacterDataEntity(
    id=id,
    name = name,
    status=status,
    species=species,
    type=type,
    gender=gender,
    location = location.map(),
    image = image
)

fun Location.map() = LocationEntity(name)

