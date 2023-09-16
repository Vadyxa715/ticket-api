package com.example.testparttwo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@Table("ticket")
public class Role {
    @Id
    private Integer id;

    private ERole name;

    public Role(ERole name) {
        this.name = name;
    }

}