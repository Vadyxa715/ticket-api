package com.example.testparttwo.controller;

public enum TicketParam {
    SORT_PRICE("price"),
    SORT_TIME("departure_time"),
    SORT_POINT_DEPARTURE("trails.point_departure"),
    SORT_POINT_ARRIVAL("trails.point_arrival"),
    SORT_TRANSPORTER("trails.transporter_id");

    private String description;

    TicketParam(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
