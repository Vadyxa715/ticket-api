package com.example.testparttwo.servise;

import com.example.testparttwo.dto.TicketDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TicketService {

    TicketDto createTicket(TicketDto ticketDto);

    TicketDto payTicketById(Long ticketId, Long userId);//купить билет по id

    Page<TicketDto> getAll(Pageable pageable);//список всех купленных билетов

    List<TicketDto> getPaidTicketByUserId(Long id);
}
