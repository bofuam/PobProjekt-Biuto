package com.kowalczyk.journeyproject.database;

import com.kowalczyk.journeyproject.dao.ReservationBuyDao;
import com.kowalczyk.journeyproject.impldao.ReservationDaoImpl;
import com.kowalczyk.journeyproject.repo.*;

import java.util.List;
import java.util.Scanner;

/**
 * Created by JK on 2016-05-19.
 */
public class ReservationLogic extends ReservationBuyLogic{

    public ReservationLogic(List<?> journeyList, InsertJourneys insertJourneys) {
        super(journeyList, insertJourneys);
    }
    @Override
    public void findWantedJourneyAndSave(){
        int number = getWhatJourneyNumber() - 1;
        Journey journey = (Journey) this.journeyList.get(number);
        Reservation reservation = new Reservation(getNameFromUser(), journey.toString());
        insertJourneys.createReservation(reservation);
    }

}
