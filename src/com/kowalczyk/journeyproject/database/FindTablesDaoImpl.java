package com.kowalczyk.journeyproject.database;

import com.kowalczyk.journeyproject.repo.*;
import com.kowalczyk.journeyproject.dao.FindTablesDao;
import com.kowalczyk.journeyproject.impldao.*;

import java.util.List;

/**
 * Created by JK on 2016-05-17.
 */
public class FindTablesDaoImpl implements FindTablesDao {
    @Override
    public List<BuyTable> getBuyTableList() {
        return buyTableList;
    }

    @Override
    public List<Reservation> getReservationList() {
        return reservationList;
    }

    @Override
    public List<RelaxJourney> getRelaxJourneyList() {
        return relaxJourneyList;
    }

    @Override
    public List<TourJourney> getTourJourneyList() {
        return tourJourneyList;
    }

    @Override
    public List<SeeingJourney> getSeeingJourneyList() {
        return seeingJourneyList;
    }

    @Override
    public void setBuyTableList(BuyDaiImpl buyDai) {
        buyTableList = buyDai.findAllBuyTables();
    }

    @Override
    public void setReservationList(ReservationDaoImpl reservationDao) {
        reservationList = reservationDao.findAllReservations();
    }

    @Override
    public void setRelaxList(RelaxDaoImpl relaxDao) {
        relaxJourneyList = relaxDao.findAllRelaxes();
    }

    @Override
    public void setTourList(TourDaoImpl tourDao) {
        tourJourneyList = tourDao.findAllTours();
    }

    @Override
    public void setSeeingList(SeeingDaoImpl seeingDao) {
        seeingJourneyList = seeingDao.findAllSeeings();
    }

    private List<BuyTable> buyTableList;
    private List<Reservation> reservationList;
    private List<RelaxJourney> relaxJourneyList;
    private List<TourJourney> tourJourneyList;
    private List<SeeingJourney> seeingJourneyList;
}
