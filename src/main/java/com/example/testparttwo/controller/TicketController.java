package com.example.testparttwo.controller;

import com.example.testparttwo.dto.TicketDto;
import com.example.testparttwo.dto.UserDto;
import com.example.testparttwo.servise.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/tickets", produces = "application/json; charset=utf-8")//ручная установка родировки для swagger3
public class TicketController {
    private TicketService ticketService;
    private TicketParam ticketParam;

    @Operation(summary = "Отобразить все доступные для покупки билеты")
    @RequestMapping(method = RequestMethod.GET)
    public Page<TicketDto> getAllAvailableTicket (
            @RequestParam(defaultValue = "SORT_TIME", required = false) TicketParam sort,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "3", required = false) int size,
            @RequestParam(defaultValue = "ASC", required = false) String order
    ){
        Pageable paging = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(order), String.valueOf(sort.getDescription())));
        Page<TicketDto> ticketsToList = ticketService.getAllAvailableTicket(paging);
        //TO DO VALIDATION
        return ticketsToList;
    }
}
