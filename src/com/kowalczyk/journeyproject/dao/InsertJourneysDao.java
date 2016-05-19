package com.kowalczyk.journeyproject.dao;

import com.kowalczyk.journeyproject.repo.*;

import java.util.List;

/**
 * Created by JK on 2016-05-16.
 */
public interface InsertJourneysDao {
    void setConnection();

    void setStatement();
    void createBase();
    void createDaosImpls();
    void createRelaxJourney(RelaxJourney relaxJourney);
    void createTourJourney(TourJourney tourJourney);
    void createSeeingJourney(SeeingJourney seeingJourney);

    void createReservation(Reservation reservation);

    void createBuyTable(BuyTable buyTable);
    void setConnectionAndStatemnt();
}
