package com.wisetest.data.mapper

import com.wisetest.data.model.dto.CharacterData
import com.wisetest.data.model.dto.CharacterDto
import com.wisetest.data.model.dto.Location
import com.wisetest.data.model.entity.CharacterDataEntity
import com.wisetest.data.model.entity.CharacterEntity
import com.wisetest.data.model.entity.LocationEntity

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
