package com.example.testparttwo.servise.impl;

import com.example.testparttwo.dto.TransporterDto;
import com.example.testparttwo.entity.Transporter;
import com.example.testparttwo.mapper.TransporterMapper;
import com.example.testparttwo.repo.TransporterRepo;
import com.example.testparttwo.servise.TransporterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class TransporterServiceImpl implements TransporterService {

    private final TransporterRepo transporterRepo;

    @Override
    public TransporterDto create(TransporterDto transporterDto) {
        Transporter transporter = TransporterMapper.convert(transporterDto);
        int saveTransporterId = transporterRepo.save(transporter);
        Transporter inserted = transporterRepo.findById((long)saveTransporterId);
        return TransporterMapper.revert(inserted);
    }

    @Override
    public TransporterDto get(Long id) {
        Transporter transporter = transporterRepo.findById(id);
        return TransporterMapper.revert(transporter);
    }
}
