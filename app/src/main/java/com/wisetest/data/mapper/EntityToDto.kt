package com.wisetest.data.mapper

import com.wisetest.data.model.dto.CharacterData
import com.wisetest.data.model.dto.CharacterDto
import com.wisetest.data.model.dto.Location
import com.wisetest.data.model.entity.CharacterDataEntity
import com.wisetest.data.model.entity.CharacterEntity
import com.wisetest.data.model.entity.LocationEntity

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