package com.example.testparttwo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrailDto {
    @Schema(description = "ID поездки", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @Schema(description = "место отправления", example = "Moscow", requiredMode = Schema.RequiredMode.REQUIRED)
    private String pointDeparture;
    @Schema(description = "место прибытия", example = "Moscow", requiredMode = Schema.RequiredMode.REQUIRED)
    private String pointArrival;
    @Schema(description = "время в пути", example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer duration;

    public TrailDto(String pointDeparture, String pointArrival, Integer duration) {
        this.pointDeparture = pointDeparture;
        this.pointArrival = pointArrival;
        this.duration = duration;
    }
}
