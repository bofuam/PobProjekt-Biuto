package com.kowalczyk.journeyproject.repo;

/**
 * Created by JK on 2016-05-16.
 */
public class Reservation {
    private String userName;
    private String aboutJourney;

    public Reservation(String userName, String aboutJourney) {
        this.userName = userName;
        this.aboutJourney = aboutJourney;
    }

    public Reservation() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAboutJourney() {
        return aboutJourney;
    }

    public void setAboutJourney(String aboutJourney) {
        this.aboutJourney = aboutJourney;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "userName='" + userName + '\'' +
                ", aboutJourney='" + aboutJourney + '\'' +
                '}';
    }
}
