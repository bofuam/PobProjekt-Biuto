package com.kowalczyk.journeyproject.repo;

import java.util.ArrayList;

/**
 * Created by JK on 2016-05-12.
 */
public class SeeingJourney extends Journey {
    public SeeingJourney(String name, Place place, String date, Hotel hotel, String airport, int price, String attractions) {
        super(name, place, date, hotel, airport, price);
        this.attractions = attractions;
    }

    public SeeingJourney() {
    }

    private String attractions;

    public void setAttractions(String attractions) {
        this.attractions = attractions;
    }

    public String getAttractions() {
        return attractions;
    }

    @Override
    public String toString() {
        return "SeeingJourney{" +
                "attractions='" + attractions + '\'' +
                "} " + super.toString();
    }

}
