package com.kowalczyk.journeyproject.repo;

import java.util.ArrayList;

/**
 * Created by JK on 2016-05-12.
 */
public abstract class Journey {
    private String name;
    private Place place;
    private String date;
    private Hotel hotel;
    private String airport;
    private int price;

    public Journey(String name, Place place, String date, Hotel hotel, String airport, int price) {
        this.name = name;
        this.place = place;
        this.date = date;
        this.hotel = hotel;
        this.airport = airport;
        this.price = price;
    }

    public Journey() {

    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Place getPlace() {
        return place;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Journey{" +
                "name='" + name + '\'' +
                ", place=" + place +
                ", date='" + date + '\'' +
                ", hotel=" + hotel +
                ", airport='" + airport + '\'' +
                ", price=" + price +
                '}';
    }
}
