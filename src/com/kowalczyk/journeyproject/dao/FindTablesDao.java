package com.kowalczyk.journeyproject.dao;

import com.kowalczyk.journeyproject.repo.*;
import com.kowalczyk.journeyproject.impldao.*;

import java.util.List;

/**
 * Created by JK on 2016-05-17.
 */
public interface FindTablesDao {
    List<BuyTable> getBuyTableList();

    List<Reservation> getReservationList();

    List<RelaxJourney> getRelaxJourneyList();

    List<TourJourney> getTourJourneyList();

    List<SeeingJourney> getSeeingJourneyList();
    void setBuyTableList(BuyDaiImpl buyDai);
    void setReservationList(ReservationDaoImpl reservationDao);

    void setRelaxList(RelaxDaoImpl relaxDao);

    void setTourList(TourDaoImpl tourDao);

    void setSeeingList(SeeingDaoImpl seeingDao);

}
