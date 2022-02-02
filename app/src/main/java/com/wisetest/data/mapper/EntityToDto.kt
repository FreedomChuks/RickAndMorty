package com.wisetest.data.mapper

import com.wisetest.data.network.dto.CharacterData
import com.wisetest.data.network.dto.CharacterDto
import com.wisetest.data.network.dto.Location
import com.wisetest.data.cache.entities.CharacterDataEntity
import com.wisetest.data.cache.entities.CharacterEntity
import com.wisetest.data.cache.entities.LocationEntity

/** Map Entity  to Dto **/
internal fun CharacterEntity.toDto() = CharacterDto(
    pages= id,
    results = results.map { item->item.map() }
)

internal fun CharacterDataEntity.map() = CharacterData(
    id=id,
    name = name,
    status=status,
    species=species,
    type=type,
    gender=gender,
    location = location.map(),
    image = image
)

fun LocationEntity.map() = Location(locationName)