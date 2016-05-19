package com.kowalczyk.journeyproject.repo;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by JK on 2016-05-12.
 */
public class Place {
    private String name;

    public Place(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Place{" +
                "name='" + name + '\'' +
                '}';
    }
}
