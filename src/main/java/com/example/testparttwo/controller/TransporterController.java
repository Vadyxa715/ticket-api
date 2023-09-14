package com.example.testparttwo.controller;

import com.example.testparttwo.dto.TransporterDto;
import com.example.testparttwo.servise.TransporterService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/transporters", produces = "application/json; charset=utf-8")
public class TransporterController {

    @Autowired
    TransporterService transporterService;

    @Operation(summary = "Создать нового транспортера")
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<TransporterDto> createTransporter (@RequestBody TransporterDto transporterDto){
        try{
            transporterService.create(new TransporterDto(
                    transporterDto.getName(),
                    transporterDto.getPhone()
                    ));
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Подучить транспортера по id")
    @RequestMapping(method = RequestMethod.GET, value = "/get{id}")
    public ResponseEntity<TransporterDto> getById (@PathVariable Long id){
        TransporterDto findTransporter = transporterService.get(id);
        return new ResponseEntity<>(findTransporter, HttpStatus.FOUND);
    }
}
