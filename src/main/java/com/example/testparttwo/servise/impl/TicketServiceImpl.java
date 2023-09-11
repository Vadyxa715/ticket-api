package com.example.testparttwo.servise.impl;

import com.example.testparttwo.dto.TicketDto;
import com.example.testparttwo.servise.TicketService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class TicketServiceImpl implements TicketService {
    @Override
    public TicketDto createTicket(TicketDto ticketDto) {
        return null;
    }

    @Override
    public TicketDto getUserByTicketId(TicketDto ticketDto) {
        return null;
    }



    @Override
    public TicketDto getTransporterByTicketId(TicketDto ticketDto) {
        return null;
    }

    @Override
    public Page<TicketDto> getAllAvailableTicket(Pageable pageable) {
        return null;
    }

    @Override
    public TicketDto payTicketById(Long ticketId) {
        return null;
    }

    @Override
    public Page<TicketDto> getAllPaidTicket(Pageable pageable) {
        return null;
    }
}
