package com.example.testparttwo.servise.impl;

import com.example.testparttwo.dto.TransporterDto;
import com.example.testparttwo.entity.Transporter;
import com.example.testparttwo.mapper.TransporterMapper;
import com.example.testparttwo.repo.TransporterRepo;
import com.example.testparttwo.servise.TrailService;
import com.example.testparttwo.servise.TransporterService;
import org.springframework.stereotype.Component;

@Component
public class TransporterServiceImpl implements TransporterService {

    TransporterRepo transporterRepo;

    public TransporterServiceImpl(TransporterRepo transporterRepo) {
        this.transporterRepo = transporterRepo;
    }

    @Override
    public TransporterDto createTransporter(TransporterDto transporterDto) {
        Transporter transporter = TransporterMapper.convert(transporterDto);
        int saveTransporterId = transporterRepo.save(transporter);
        Transporter inserted = transporterRepo.findById((long)saveTransporterId);
        return TransporterMapper.revert(inserted);
    }
}
