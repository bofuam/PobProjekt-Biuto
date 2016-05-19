package com.kowalczyk.journeyproject.dao;

import java.util.Scanner;

/**
 * Created by JK on 2016-05-18.
 */
public interface AddNewJourneyDao {
    void displayWhatJourneyType();

    void checkWhatJourneyType();

    void getTourJourneyFromUser();

    void getSeeingJourneyFromUser();

    void getRelaxJourneyFromUser();

    void saveTourJourney();

    void saveSeeingJourney();

    void saveRelaxJourney();

    String[] getTourFromUser();
    int getPrice();
}
