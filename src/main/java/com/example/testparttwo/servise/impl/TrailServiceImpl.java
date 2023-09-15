package com.example.testparttwo.servise.impl;

import com.example.testparttwo.dto.TrailDto;
import com.example.testparttwo.entity.Trail;
import com.example.testparttwo.mapper.MapperTrail;
import com.example.testparttwo.repo.TrailRepo;
import com.example.testparttwo.servise.TrailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class TrailServiceImpl implements TrailService {

    private final TrailRepo trailRepo;
    private final MapperTrail mapperTrail;
    @Override
    public TrailDto create(TrailDto trailDto) {
        Trail trail = mapperTrail.toEntity(trailDto);
        int find = trailRepo.save(trail);
        Trail insert = trailRepo.findById((long) find);
        return mapperTrail.toDto(insert);
    }

    @Override
    public TrailDto get(Long id) {
        Trail trail = trailRepo.findById(id);
        return mapperTrail.toDto(trail);
    }
}
