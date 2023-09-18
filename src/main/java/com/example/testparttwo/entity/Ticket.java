package com.example.testparttwo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Table("ticket")
public class Ticket {

    @Id
    private Long ticketId;
    private Date departureTime;
    private Integer place;
    private Double price;
    private Boolean paid;
    private Long userId;
    private Long trailId;

    public Ticket(Long ticketId, Date departureTime, Integer place, Double price, Boolean paid) {
        this.ticketId = ticketId;
        this.departureTime = departureTime;
        this.place = place;
        this.price = price;
        this.paid = paid;
    }

    public Ticket(Date departureTime, Integer place, Double price, Boolean paid) {
        this.departureTime = departureTime;
        this.place = place;
        this.price = price;
        this.paid = paid;
    }

    public Ticket(Date departureTime, Integer place, Double price, Boolean paid, Long userId, Long trailId) {
        this.departureTime = departureTime;
        this.place = place;
        this.price = price;
        this.paid = paid;
        this.userId = userId;
        this.trailId = trailId;
    }
}