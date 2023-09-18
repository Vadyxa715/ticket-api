package com.example.testparttwo.servise.impl;

import com.example.testparttwo.dto.TicketDto;
import com.example.testparttwo.entity.Ticket;
import com.example.testparttwo.mapper.MapperTicketImpl;
import com.example.testparttwo.repo.TicketRepo;
import com.example.testparttwo.servise.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class TicketServiceImpl implements TicketService {

    private final TicketRepo ticketRepo;
    private final MapperTicketImpl mapperTicket;


    @Override
    public TicketDto createTicket(TicketDto ticketDto) {
        Ticket ticket = mapperTicket.toEntity(ticketDto);
        int saveTicket = ticketRepo.save(ticket);
        Ticket inserted = ticketRepo.findById((long) saveTicket);
        return mapperTicket.toDto(inserted);
    }

    @Override
    public TicketDto payTicketById(Long ticketId, Long userId) {
        int payTicket = ticketRepo.bayTicket(ticketId, userId);
        Ticket payTicketId = ticketRepo.findById((long) payTicket);
        return mapperTicket.toDto(payTicketId);
    }

    @Override
    public Page<TicketDto> getAll(Pageable myPageable) {
        Page<Ticket> ticketsPage = ticketRepo.findAll(myPageable);
        return ticketsPage.map(mapperTicket::toDto);
    }

    @Override
    public List<TicketDto> getPaidTicketByUserId(Long id) {
        List<Ticket> tickets = ticketRepo.findPaidByUser(id);
        return tickets.stream().map(mapperTicket::toDto).toList();
    }
}

