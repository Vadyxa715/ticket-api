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
}
