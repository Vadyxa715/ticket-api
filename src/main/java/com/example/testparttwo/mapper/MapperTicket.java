package com.example.testparttwo.mapper;

import com.example.testparttwo.dto.TicketDto;
import com.example.testparttwo.entity.Ticket;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface MapperTicket {
    TicketDto toDto(Ticket ticket);
    Ticket toEntity(TicketDto ticketDto);
}
