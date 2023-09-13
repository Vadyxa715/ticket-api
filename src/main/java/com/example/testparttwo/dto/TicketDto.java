package com.example.testparttwo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {


    private Long id;
    private Date departureTime;
    private Integer place;
    private Double price;
    private Boolean paid;

//    private TrailDto trailDto;
//    private Long trailId = trailDto.getId();
//
//    private UserDto userDto;
//    private Long userId = userDto.getId();

    private Long userId;

    private Long trailId;


    public TicketDto(Date departureTime, Integer place, Double price, Boolean paid, Long trailId, Long userId) {
        this.departureTime = departureTime;
        this.place = place;
        this.price = price;
        this.paid = paid;
        this.trailId = trailId;
        this.userId = userId;
    }

}
