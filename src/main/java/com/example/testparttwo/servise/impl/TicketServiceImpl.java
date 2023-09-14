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
    public Page<TicketDto> getAll(Pageable myPageable) {
        Page<Ticket> ticketsPage = ticketRepo.findAll(myPageable);
        return ticketsPage.map(TicketMapper::convert);
    }
}

