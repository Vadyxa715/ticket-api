package com.example.testparttwo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrailDto {
    @Schema(name = "Идентификатор", description = "ID поездки", example = "1", requiredMode = Schema.RequiredMode.REQUIRED, accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @Schema(name = "Отправление", description = "место отправления", example = "Moscow", requiredMode = Schema.RequiredMode.REQUIRED)
    private String pointDeparture;
    @Schema(name = "Прибытие", description = "место прибытия", example = "Moscow", requiredMode = Schema.RequiredMode.REQUIRED)
    private String pointArrival;
    @Schema(name = "Время(ч)", description = "время в пути", example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer duration;

    public TrailDto(String pointDeparture, String pointArrival, Integer duration) {
        this.pointDeparture = pointDeparture;
        this.pointArrival = pointArrival;
        this.duration = duration;
    }
}
