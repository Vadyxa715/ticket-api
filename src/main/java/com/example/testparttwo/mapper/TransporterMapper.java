package com.example.testparttwo.mapper;

import com.example.testparttwo.dto.TransporterDto;
import com.example.testparttwo.entity.Transporter;

public class TransporterMapper {
    public static Transporter convert(TransporterDto transporterDto) {
        if (transporterDto == null) return null;
        return new Transporter(
                transporterDto.getId(),
                transporterDto.getName(),
                transporterDto.getPhone()
        );
    }

    public static TransporterDto revert(Transporter transporter) {
        if (transporter == null) return null;
        return new TransporterDto(
                transporter.getId(),
                transporter.getName(),
                transporter.getPhone()
        );
    }
}
