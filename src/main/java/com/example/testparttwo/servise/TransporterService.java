package com.example.testparttwo.servise;

import com.example.testparttwo.dto.TransporterDto;

public interface TransporterService {
    TransporterDto create (TransporterDto transporterDto);

    TransporterDto get(Long id);
}
