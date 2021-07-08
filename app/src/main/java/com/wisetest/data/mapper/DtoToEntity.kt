package com.wisetest.data.mapper

import com.wisetest.data.model.dto.CharacterData
import com.wisetest.data.model.dto.Location
import com.wisetest.data.model.entity.CharacterEntity
import com.wisetest.data.model.entity.LocationEntity

/** Map Dto to Entity **/
internal fun CharacterData.toEntity() = CharacterEntity(
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
