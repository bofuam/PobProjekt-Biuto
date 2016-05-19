package com.kowalczyk.journeyproject.repo;

import java.util.ArrayList;

/**
 * Created by JK on 2016-05-12.
 */
public class Hotel {
    public Hotel(String name) {
        this.name = name;
    }

    public Hotel(ArrayList<String> names) {
        this.names = names;
    }

    private String name;
    private ArrayList<String> names;

    public void setName(String name) {
        this.name = name;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                '}';
    }
}
