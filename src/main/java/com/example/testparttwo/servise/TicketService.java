package com.example.testparttwo.servise;

import com.example.testparttwo.dto.TicketDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketService {

    TicketDto createTicket(TicketDto ticketDto);

    TicketDto getUserByTicketId(TicketDto ticketDto);

    TicketDto getAllTicketToPay(TicketDto ticketDto);//получить все которые можно купить

    TicketDto getTransporterByTicketId(TicketDto ticketDto);//получить перевозчика по билету


    Page<TicketDto> getAllAvailableTicket (Pageable pageable);//доступные билеты для покупки

    TicketDto payTicketById (Long ticketId);//купить билет по id

    Page<TicketDto> getAllPaidTicket (Pageable pageable);//список всех купленных билетов


}
