package com.example.testparttwo.controller;

import com.example.testparttwo.controller.customException.EntityNotFoundException;
import com.example.testparttwo.dto.TransporterDto;
import com.example.testparttwo.servise.TransporterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/transporters", produces = "application/json; charset=utf-8")
@SecurityRequirement(name = "Authorization")
public class TransporterController {

    @Autowired
    TransporterService transporterService;

    @Operation(summary = "Создать нового транспортера")
    @PostMapping
    public ResponseEntity<TransporterDto> createTransporter (@RequestBody TransporterDto transporterDto){
            transporterService.create(new TransporterDto(
                    transporterDto.getName(),
                    transporterDto.getPhone()
                    ));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Получить транспортера по id")
    @GetMapping(value = "/get{id}")
    public ResponseEntity<TransporterDto> getById (@PathVariable Long id){
        TransporterDto findTransporter = transporterService.get(id);
        return new ResponseEntity<>(findTransporter, HttpStatus.FOUND);
    }
}
