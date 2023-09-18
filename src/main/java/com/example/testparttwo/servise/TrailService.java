package com.example.testparttwo.servise;

import com.example.testparttwo.dto.TrailDto;

public interface TrailService {
    TrailDto create (TrailDto trailDto);

    TrailDto get (Long id);
}
