package com.example.testparttwo.controller;

import com.example.testparttwo.dto.TransporterDto;
import com.example.testparttwo.repo.TransporterRepo;
import com.example.testparttwo.servise.TransporterService;
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
@RequestMapping(value = "/transporters", produces = "application/json; charset=utf-8")
//ручная установка кодировки для swagger3
public class TransporterController {

    @Autowired
    TransporterRepo transporterRepo;
    TransporterService transporterService;

    @Operation(summary = "Создать нового транспортера")
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<TransporterDto> createTransporter (@RequestBody TransporterDto transporterDto){
        try{
            transporterService.createTransporter(new TransporterDto(
                    transporterDto.getName(),
                    transporterDto.getPhone()
                    ));
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @Operation(summary = "Показать всех транспортеров")
//    @RequestMapping(method = RequestMethod.GET, value = "/gelAll")
//    public ResponseEntity<List<TransporterDto>> getAllTransporter (){
//        try{
//            List<TransporterDto> transporterDtos = new ArrayList<TransporterDto>();
//
//
//            return new ResponseEntity<>(transporters, HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR)
//        }
//    }
}
