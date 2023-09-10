package com.example.testparttwo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "trail")//маршрут
public class Trail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pointDeparture")//поинт отправление
    private String pointDeparture;

    @Column(name = "pointArrival")//поинт прибытия
    private String pointArrival;

    @ManyToOne(fetch = FetchType.LAZY)//маршрутов много транспартер один
    @JoinTable(name = "transporter",
               joinColumns ={@JoinColumn(name = "trails_id", referencedColumnName = "id")},
               inverseJoinColumns = {@JoinColumn(name = "transporter_id", referencedColumnName = "id")})//транспортер
    private Transporter transporter;

    @Column(name = "duration")
    private Integer duration;//разница между временем отправления и прибытия *ВОЗМОЖНО*
    //и или время от отправления до текущего если не пришло, и см выше

    @OneToMany(mappedBy = "ticket")//если не пригодится удалить
    private List<Ticket> tickets;

    public Trail(Long id, String pointDeparture, String pointArrival, Integer duration) {
        this.id = id;
        this.pointDeparture = pointDeparture;
        this.pointArrival = pointArrival;
        this.duration = duration;
    }

}
