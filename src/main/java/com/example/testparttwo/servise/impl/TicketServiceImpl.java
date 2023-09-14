package com.example.testparttwo.servise.impl;

import com.example.testparttwo.dto.TicketDto;
import com.example.testparttwo.entity.Ticket;
import com.example.testparttwo.mapper.TicketMapper;
import com.example.testparttwo.repo.TicketRepo;
import com.example.testparttwo.servise.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class TicketServiceImpl implements TicketService {

    private final TicketRepo ticketRepo;


    @Override
    public TicketDto createTicket(TicketDto ticketDto) {
        Ticket ticket = TicketMapper.revert(ticketDto);
        int saveTicket = ticketRepo.save(ticket);
        Ticket inserted = ticketRepo.findById((long) saveTicket);
        return TicketMapper.convert(inserted);//вернуть по пришедшему id
    }

//    @Override
//    public TicketDto payTicketById(Long ticketId, Long userId) {
//        Ticket payTicket = ticketRepo.findById(ticketId);
//        return TicketMapper.convert(payTicket);
//    }

    @Override
    public TicketDto payTicketById(Long ticketId, Long userId) {
        int payTicket = ticketRepo.bayTicket(ticketId, userId);
        Ticket payTicketId = ticketRepo.findById((long) payTicket);
        return TicketMapper.convert(payTicketId);
    }

    @Override
    public Page<TicketDto> getAll(Pageable myPageable) {
        Page<Ticket> ticketsPage = ticketRepo.findAll(myPageable);
        return ticketsPage.map(TicketMapper::convert);
    }

    @Override
    public List<TicketDto> getPaidTicketByUserId(Long id) {
        List<Ticket> tickets = ticketRepo.findPaidByUser(id);
        return tickets.stream().map(TicketMapper::convert).toList();
    }
}

