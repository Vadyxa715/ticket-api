package com.example.testparttwo.servise.impl;

import com.example.testparttwo.dto.TransporterDto;
import com.example.testparttwo.entity.Transporter;
import com.example.testparttwo.mapper.MapperTransporter;
import com.example.testparttwo.repo.TransporterRepo;
import com.example.testparttwo.servise.TransporterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class TransporterServiceImpl implements TransporterService {

    private final TransporterRepo transporterRepo;
    private final MapperTransporter mapperTransporter;

    @Override
    public TransporterDto create(TransporterDto transporterDto) {
        Transporter transporter = mapperTransporter.toEntity(transporterDto);
        int saveTransporterId = transporterRepo.save(transporter);
        Transporter inserted = transporterRepo.findById((long)saveTransporterId);
        return mapperTransporter.toDto(inserted);
    }

    @Override
    public TransporterDto get(Long id) {
        Transporter transporter = transporterRepo.findById(id);
        return mapperTransporter.toDto(transporter);
    }
}
