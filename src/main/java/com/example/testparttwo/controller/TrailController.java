package com.example.testparttwo.controller;

import com.example.testparttwo.dto.TrailDto;
import com.example.testparttwo.servise.TrailService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/trails", produces = "application/json; charset=utf-8")
public class TrailController {

    @Autowired
    private final TrailService trailService;

    @Operation(summary = "Создать маршрут/поездку")
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<TrailDto> createTrail (@RequestBody TrailDto trailDto){
        try{
            trailService.create(new TrailDto(
                    trailDto.getPointDeparture(),
                    trailDto.getPointArrival(),
                    trailDto.getDuration()
            ));
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Получить маршрут по id")
    @RequestMapping(method = RequestMethod.GET, value = "/get{id}")
    public ResponseEntity<TrailDto> getById (@PathVariable Long id){
        TrailDto findTrail = trailService.get(id);
        return new ResponseEntity<>(findTrail, HttpStatus.FOUND);
    }
}
