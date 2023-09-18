package com.example.testparttwo.controller;

import com.example.testparttwo.dto.TicketDto;
import com.example.testparttwo.servise.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/tickets", produces = "application/json; charset=utf-8")
@SecurityRequirement(name = "Authorization")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Operation(summary = "Создать билет для пользователя")
    @RequestMapping(method = RequestMethod.POST, value = "/createTicketByUserIdAndTrailId")
    public ResponseEntity<TicketDto> createTicket(@RequestBody TicketDto ticketDto) {
        try {
            ticketService.createTicket(new TicketDto(
                    ticketDto.getDepartureTime(),
                    ticketDto.getPlace(),
                    ticketDto.getPrice(),
                    ticketDto.getPaid(),
                    ticketDto.getTrailId(),
                    ticketDto.getUserId()
            ));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Получить все билеты")
    @RequestMapping(method = RequestMethod.GET, value = "/getAllWithPagination")
    public ResponseEntity<Page<TicketDto>> getAllTickets(
            @RequestParam(defaultValue = "SORT_TIME", required = false) TicketParam sort,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "3", required = false) int size,
            @RequestParam(defaultValue = "ASC", required = false) String order
    ){
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(order), sort.getDescription()));
        Page<TicketDto> tickets = ticketService.getAll(pageable);
        if(tickets.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @Operation(summary = "Получить купленные билеты пользователя")
    @RequestMapping(method = RequestMethod.GET, value = "/getAllPaidTicketByUserId{id}")
    public ResponseEntity<List<TicketDto>> getAllPaidTicket(@PathVariable Long id){
        try{
            List<TicketDto> ticketDto = new ArrayList<>(ticketService.getPaidTicketByUserId(id));
            return new ResponseEntity<>(ticketDto, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Купить билет")
    @RequestMapping(method = RequestMethod.PUT, value = "/payTicket{ticketId}byUser{userId}")
    public ResponseEntity<TicketDto> payTicket(@PathVariable(value = "ticketId") Long ticketId,
                                               @PathVariable(value = "userId") Long userId){
        TicketDto paidTicket = ticketService.payTicketById(ticketId, userId);
        return new ResponseEntity<>(paidTicket, HttpStatus.OK);
    }
}
