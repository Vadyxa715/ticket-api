package com.example.testparttwo.mapper;

import com.example.testparttwo.dto.TrailDto;
import com.example.testparttwo.entity.Trail;

public class TrailMapper {
    public static TrailDto convert(Trail trail) {
        if (trail == null) return null;
        return new TrailDto(
                trail.getTrailId(),
                trail.getPointDeparture(),
                trail.getPointDeparture(),
                trail.getDuration()
        );
    }

    public static Trail revert(TrailDto trailDto) {
        if (trailDto == null) return null;
        return new Trail(
                trailDto.getId(),
                trailDto.getPointDeparture(),
                trailDto.getPointArrival(),
                trailDto.getDuration()
        );
    }
}
