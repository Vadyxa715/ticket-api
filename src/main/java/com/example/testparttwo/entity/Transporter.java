package com.example.testparttwo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Data
@NoArgsConstructor
@Table("transporter")
public class Transporter {

    @Id
    private Long transporterId;
    private String name;
    private String phone;

    @MappedCollection(keyColumn = "TRANSPORTER_ID", idColumn = "TRANSPORTER_ID")
    private Set<Trail> trails;

    public Transporter(Long transporterId, String name, String phone) {
        this.transporterId = transporterId;
        this.name = name;
        this.phone = phone;
    }

    public Transporter(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
