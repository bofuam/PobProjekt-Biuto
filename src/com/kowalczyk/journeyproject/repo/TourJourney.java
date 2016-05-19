package com.kowalczyk.journeyproject.repo;

import java.util.ArrayList;

/**
 * Created by JK on 2016-05-12.
 */
public class TourJourney extends Journey {

    public TourJourney(String name, Place place, String date, Hotel hotel, String airport, int price) {
        super(name, place, date, hotel, airport, price);
    }

    public TourJourney() {

    }

    @Override
    public String toString() {
        return "TourJourney{} " + super.toString();
    }
}
