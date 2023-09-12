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
    private Boolean paid;       //Когда купим изменяем состояние для пользователя.

    private User user;//OneToOne

    @MappedCollection(keyColumn = "TICKET_ID", idColumn = "TICKET_ID")
    private Set<Trail> trails;

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
}