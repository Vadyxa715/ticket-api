package com.example.testparttwo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Data
@NoArgsConstructor
@Table("trail")//маршрут
public class Trail {

    @Id
    private Long trailId;
    //поинт отправление
    private String pointDeparture;

    //поинт прибытия
    private String pointArrival;

    @MappedCollection(keyColumn = "TRAIL_ID", idColumn = "TRAIL_ID")
    private Set<Transporter> transporters;

    private Integer duration;//время в пути

    public Trail(Long trailId, String pointDeparture, String pointArrival, Integer duration) {
        this.trailId = trailId;
        this.pointDeparture = pointDeparture;
        this.pointArrival = pointArrival;
        this.duration = duration;
    }

}
