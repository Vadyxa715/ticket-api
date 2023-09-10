package com.example.testparttwo.controller;

public enum TicketParam {
    SORT_TIME("departureTime"),
    SORT_POINT_DEPARTURE("trail.pointDeparture"),
    SORT_POINT_ARRIVAL("trail.pointArrival"),
    SORT_TRANSPORTER("trail.transporter.name");

    private String description;

    TicketParam(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
