package com.example.testparttwo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransporterDto {
    private Long id;
    @NonNull
    private String name;
    private String phone;
}
