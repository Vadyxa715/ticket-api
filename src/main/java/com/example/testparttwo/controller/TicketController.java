package com.example.testparttwo.controller;

import com.example.testparttwo.dto.TicketDto;
import com.example.testparttwo.entity.Ticket;
import com.example.testparttwo.repo.TicketRepo;
import com.example.testparttwo.servise.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/tickets", produces = "application/json; charset=utf-8")
//ручная установка родировки для swagger3
public class TicketController {

    @Autowired
    private TicketRepo ticketRepo;
    private TicketService ticketService;
    // private TicketParam ticketParam;

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

    @Operation(summary = "получить все билеты")
    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        try {
            List<Ticket> tickets = new ArrayList<Ticket>();
            ticketRepo.findAll().forEach(tickets::add);
            if (tickets.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(tickets, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @Operation(summary = "получить список купленных билетов пользователя по id")
//    @RequestMapping(method = RequestMethod.GET, value = "/getAllPaidTicketsByUserId")
//    public ResponseEntity<List<Ticket>> getAllPaid() {
//        try {
//
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }


//    @Operation(summary = "Отобразить все доступные для покупки билеты")
//    @RequestMapping(method = RequestMethod.GET)
//    public Page<TicketDto> getAllAvailableTicket(
//            @RequestParam(defaultValue = "SORT_TIME", required = false) TicketParam sort,
//            @RequestParam(defaultValue = "0", required = false) int page,
//            @RequestParam(defaultValue = "3", required = false) int size,
//            @RequestParam(defaultValue = "ASC", required = false) String order
//    ) {
//        Pageable paging = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(order), String.valueOf(sort.getDescription())));
//        Page<TicketDto> ticketsToList = ticketService.getAllAvailableTicket(paging);
//        //TO DO VALIDATION
//        return ticketsToList;
//    }
}
