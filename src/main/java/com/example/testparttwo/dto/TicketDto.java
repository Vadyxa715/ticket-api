package com.example.testparttwo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {


    @Schema(description = "Идентификатор", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private Date departureTime;
    private Integer place;
    private Double price;
    @Schema(description = "Boolean купленный", accessMode = Schema.AccessMode.READ_ONLY)
    private Boolean paid;

    private Long trailId;
    private Long userId;


    public TicketDto(Date departureTime, Integer place, Double price, Boolean paid, Long trailId, Long userId) {
        this.departureTime = departureTime;
        this.place = place;
        this.price = price;
        this.paid = paid;
        this.trailId = trailId;
        this.userId = userId;
    }
}