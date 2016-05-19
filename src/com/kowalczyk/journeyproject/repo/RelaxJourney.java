package com.kowalczyk.journeyproject.repo;

/**
 * Created by JK on 2016-05-12.
*/
public class RelaxJourney extends Journey {
    public RelaxJourney() {
        super();

    }

    public RelaxJourney(String name, Place place, String date, Hotel hotel, String airport, int price, String pool, String golf) {
        super(name, place, date, hotel, airport, price);
        this.pool = pool;
        this.golf = golf;
    }

    private String pool;
    private String golf;

    @Override
    public String toString() {
        return "RelaxJourney{" +
                "pool=" + pool +
                ", golf=" + golf +
                "} " + super.toString();
    }

    public String isPool() {
        return pool;
    }

    public void setPool(String pool) {
        this.pool = pool;
    }

    public String isGolf() {
        return golf;
    }

    public void setGolf(String golf) {
        this.golf = golf;
    }
}
