package com.example.testparttwo.controller;

import com.example.testparttwo.controller.customException.EntityNotFoundException;
import com.example.testparttwo.dto.TrailDto;
import com.example.testparttwo.servise.TrailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/trails", produces = "application/json; charset=utf-8")
@SecurityRequirement(name = "Authorization")
public class TrailController {

    @Autowired
    private final TrailService trailService;

    @Operation(summary = "Создать маршрут/поездку")
    @PostMapping
    public ResponseEntity<TrailDto> createTrail (@RequestBody TrailDto trailDto){
            trailService.create(new TrailDto(
                    trailDto.getPointDeparture(), trailDto.getPointArrival(), trailDto.getDuration()
            ));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Получить маршрут по id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<TrailDto> getById (@PathVariable Long id){
        TrailDto findTrail = trailService.get(id);
        return new ResponseEntity<>(findTrail, HttpStatus.FOUND);
    }
}
