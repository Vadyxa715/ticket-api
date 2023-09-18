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

//@Schema(name = "", description = "", example = "", requiredMode = Schema.RequiredMode.REQUIRED)
    @Schema(description = "Идентификатор", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @Schema(name = "Отправления", description = "Дата и время отправления", example = "2023-00-00T00:00:00.0000", requiredMode = Schema.RequiredMode.REQUIRED)
    private Date departureTime;
    @Schema(name = "Место", description = "Номер места", example = "88", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer place;
    @Schema(name = "Цена", description = "Цена билета", example = "1500.0", requiredMode = Schema.RequiredMode.REQUIRED)
    private Double price;
    @Schema(name = "Куплен", description = "Boolean купленный (Да/Нет)", example = "true/false", accessMode = Schema.AccessMode.READ_ONLY)
    private Boolean paid;
    @Schema(name = "Поездка", description = "Информация о поездке по ID", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long trailId;
    @Schema(name = "Пользователь", description = "Информация о пользователе по ID", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
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