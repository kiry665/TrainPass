package com.kiry665.trainpass.Models;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "train_id")
    private Train train;

    @OneToOne
    @JoinColumn(name = "station_id")
    private Station station;

    @Column(name="arrival_time")
    private Time arrival_time;

    @Column(name = "departure_time")
    private Time departure_time;

    @Column(name = "sequence_number")
    private int sequence_number;

    public Route() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Station getStation() {
        return station;
    }

    public void setStation_id(Station station) {
        this.station = station;
    }

    public Time getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(Time arrival_time) {
        this.arrival_time = arrival_time;
    }

    public Time getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(Time departure_time) {
        this.departure_time = departure_time;
    }

    public int getSequence_number() {
        return sequence_number;
    }

    public void setSequence_number(int sequence_number) {
        this.sequence_number = sequence_number;
    }
}
