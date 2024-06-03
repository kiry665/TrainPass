package com.kiry665.trainpass.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Time;

@Entity
public class RouteDetails {

    @Id
    private int id;

    private String startStationName;
    private String endStationName;
    private int trainNumber;
    private String type;
    private Time departureTime;
    private Time arrivalTime;

    public RouteDetails() {
    }

    public RouteDetails(String startStationName, String endStationName, int trainNumber, String type, Time departureTime, Time arrivalTime) {
        this.startStationName = startStationName;
        this.endStationName = endStationName;
        this.trainNumber = trainNumber;
        this.type = type;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartStationName() {
        return startStationName;
    }

    public void setStartStationName(String startStationName) {
        this.startStationName = startStationName;
    }

    public String getEndStationName() {
        return endStationName;
    }

    public void setEndStationName(String endStationName) {
        this.endStationName = endStationName;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
