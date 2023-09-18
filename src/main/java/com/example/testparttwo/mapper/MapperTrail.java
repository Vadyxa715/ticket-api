package com.example.testparttwo.mapper;

import com.example.testparttwo.dto.TrailDto;
import com.example.testparttwo.entity.Trail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface MapperTrail {
    Trail toEntity(TrailDto trailDto);
    TrailDto toDto(Trail trail);
}
