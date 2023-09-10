package com.example.testparttwo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "departure_time")//отправление
    private Date departureTime;

    @Column(name = "place")//место
    private Integer place;

    @Column(name = "price")//цена
    private Double price;


    @Column(name = "paid")      //Добавить boolean переменную - купленный.
    private Boolean paid;       //Когда купим изменяем состояние для пользователя.

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "trail",
               joinColumns ={ @JoinColumn(name = "ticket_id", referencedColumnName = "id")},
               inverseJoinColumns ={ @JoinColumn(name = "trail_id", referencedColumnName = "id")})
    private Trail trail;

    public Ticket(Long id, Date departureTime, Integer place, Double price, Boolean paid) {
        this.id = id;
        this.departureTime = departureTime;
        this.place = place;
        this.price = price;
        this.paid = paid;
    }

}
