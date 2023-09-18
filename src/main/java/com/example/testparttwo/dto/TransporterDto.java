package com.example.testparttwo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransporterDto {
    @Schema(description = "Идентификатор", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @NonNull
    @Schema(description = "название транспортной компании", example = "OOO Nord", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
    @Schema(description = "телефон для связи", example = "79991511515", requiredMode = Schema.RequiredMode.REQUIRED)
    private String phone;

    public TransporterDto(@NonNull String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
