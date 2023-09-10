package com.example.testparttwo.mapper;

import com.example.testparttwo.dto.TicketDto;
import com.example.testparttwo.entity.Ticket;

public class TicketMapper {
    public static TicketDto convert (Ticket ticket){
        if(ticket == null) return null;
        return new TicketDto(
                ticket.getId(),
                ticket.getDepartureTime(),
                ticket.getPlace(),
                ticket.getPrice(),
                ticket.getPaid()
        );
    }
    public static Ticket revert (TicketDto ticketDto){
        if (ticketDto == null) return null;
        return new Ticket(
                ticketDto.getId(),
                ticketDto.getDepartureTime(),
                ticketDto.getPlace(),
                ticketDto.getPrice(),
                ticketDto.getPaid()
        );
    }
}
