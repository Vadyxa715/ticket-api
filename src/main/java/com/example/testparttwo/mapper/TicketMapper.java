package com.example.testparttwo.mapper;

import com.example.testparttwo.dto.TicketDto;
import com.example.testparttwo.entity.Ticket;

public class TicketMapper {
    public static TicketDto convert (Ticket ticket){
        if(ticket == null) return null;
        return new TicketDto(
                ticket.getDepartureTime(),
                ticket.getPlace(),
                ticket.getPrice(),
                ticket.getPaid(),
                ticket.getTrailId(),
                ticket.getUserId()
        );
    }
    public static Ticket revert (TicketDto ticketDto){
        if (ticketDto == null) return null;
        return new Ticket(
                ticketDto.getDepartureTime(),
                ticketDto.getPlace(),
                ticketDto.getPrice(),
                ticketDto.getPaid(),
                ticketDto.getTrailId(),// getTrailDto().getId(),
                ticketDto.getUserId() //getUserDto().getId()
        );
    }
}
