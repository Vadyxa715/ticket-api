package com.example.testparttwo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrailDto {
   @Schema(description = "Идентификатор", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String pointDeparture;
    private String pointArrival;
    private Integer duration;

    public TrailDto(String pointDeparture, String pointArrival, Integer duration) {
        this.pointDeparture = pointDeparture;
        this.pointArrival = pointArrival;
        this.duration = duration;
    }
}
