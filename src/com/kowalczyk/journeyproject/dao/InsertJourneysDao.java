package com.kowalczyk.journeyproject.dao;

import com.kowalczyk.journeyproject.impldao.RelaxDaoImpl;
import com.kowalczyk.journeyproject.impldao.SeeingDaoImpl;
import com.kowalczyk.journeyproject.impldao.TourDaoImpl;
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
    void deleteTourJourney(TourJourney tourJourney);

    void deleteSeeingJourney(SeeingJourney seeingJourney);

    void deleteRelaxJourney(RelaxJourney relaxJourney);
}
