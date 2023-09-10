package com.example.testparttwo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrailDto {
    private Long id;
    private String pointDeparture;
    private String pointArrival;
    private Integer duration;
}
