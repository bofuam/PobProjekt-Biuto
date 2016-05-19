package com.kowalczyk.journeyproject.database;

import com.kowalczyk.journeyproject.repo.*;
import com.kowalczyk.journeyproject.dao.InsertJourneysDao;
import com.kowalczyk.journeyproject.impldao.*;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

/**
 * Created by JK on 2016-05-16.
 */
public class InsertJourneys implements InsertJourneysDao{
    private MainBase mainBase;
    private Connection connection;
    private Statement statement;
    private RelaxDaoImpl relaxDao;
    private TourDaoImpl tourDao;
    private SeeingDaoImpl seeingDao;
    private ReservationDaoImpl reservationDao;
    private BuyDaiImpl buyDai;

    public RelaxDaoImpl getRelaxDao() {
        return relaxDao;
    }

    public TourDaoImpl getTourDao() {
        return tourDao;
    }

    public SeeingDaoImpl getSeeingDao() {
        return seeingDao;
    }

    public BuyDaiImpl getBuyDai() {
        return buyDai;
    }

    public ReservationDaoImpl getReservationDao() {
        return reservationDao;
    }

    @Override
    public void setConnection() {
        this.connection = mainBase.getConnection();
    }

    @Override
    public void setStatement() {
        this.statement = mainBase.getStatement();
    }

    @Override
    public void createBase() {
        mainBase = new MainBase();
        mainBase.createTables();
        createDaosImpls();
    }

    @Override
    public void createDaosImpls() {
        setConnectionAndStatemnt();
        relaxDao = new RelaxDaoImpl(connection, statement);
        seeingDao = new SeeingDaoImpl(connection, statement);
        tourDao = new TourDaoImpl(connection, statement);
        reservationDao = new ReservationDaoImpl(connection, statement);
        buyDai = new BuyDaiImpl(connection, statement);
    }


    @Override
    public void createRelaxJourney(RelaxJourney relaxJourney) {
        relaxDao.insertRelax(relaxJourney);
    }

    @Override
    public void createTourJourney(TourJourney tourJourney) {
        tourDao.insertTour(tourJourney);
    }

    @Override
    public void createSeeingJourney(SeeingJourney seeingJourney) {
        seeingDao.insertSeeing(seeingJourney);
    }

    @Override
    public void createReservation(Reservation reservation) {
        reservationDao.insertReservation(reservation);
    }

    @Override
    public void createBuyTable(BuyTable buyTable) {
        buyDai.insertBuyTable(buyTable);
    }

    @Override
    public void setConnectionAndStatemnt() {
        setConnection();
        setStatement();
    }


}
