package com.kowalczyk.journeyproject.dao;

/**
 * Created by JK on 2016-05-19.
 */
public interface ReservationBuyDao {
    int getWhatJourneyNumber();
    String getNameFromUser();
    void findWantedJourneyAndSave();
}
