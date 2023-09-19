package com.example.testparttwo.servise.impl;

import com.example.testparttwo.controller.customException.EntityBadRequestException;
import com.example.testparttwo.controller.customException.EntityNotFoundException;
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
        if (inserted == null) {
            throw new EntityBadRequestException("Failed to create transporterEntity.");
        }
        return mapperTransporter.toDto(inserted);
    }

    @Override
    public TransporterDto get(Long id) {
        Transporter transporter = transporterRepo.findById(id);
        if(transporter == null){
            throw new EntityNotFoundException("Not found transporter with ID: " + id + ".");
        }
        return mapperTransporter.toDto(transporter);
    }
}
