package com.example.testparttwo.mapper;

import com.example.testparttwo.dto.TransporterDto;
import com.example.testparttwo.entity.Transporter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface MapperTransporter {
    Transporter toEntity(TransporterDto transporterDto);
    TransporterDto toDto(Transporter transporter);
}
