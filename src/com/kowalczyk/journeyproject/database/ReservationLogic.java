package com.kowalczyk.journeyproject.database;

import com.kowalczyk.journeyproject.impldao.ReservationDaoImpl;
import com.kowalczyk.journeyproject.repo.*;

import java.util.List;
import java.util.Scanner;

/**
 * Created by JK on 2016-05-19.
 */
public class ReservationLogic {
    private Scanner in ;
    private List<?> journeyList;
    private InsertJourneys insertJourneys;
    public ReservationLogic(List<?> journeyList, InsertJourneys insertJourneys) {
        in = new Scanner(System.in);
        this.journeyList = journeyList;
        this.insertJourneys = insertJourneys;
        findWantedJourneyAndSave();
    }

    public int getWhatJourneyNumber(){
        System.out.println("wkich journey u want reserve? pick number");
        return in.nextInt();
    }
    public String getNameFromUser(){
        System.out.println("give me your name");
        in.nextLine();
        return in.nextLine();
    }
    public void findWantedJourneyAndSave(){
        int number = getWhatJourneyNumber();
        Journey journey = (Journey) journeyList.get(number--);
        Reservation reservation = new Reservation(getNameFromUser(), journey.toString());
        insertJourneys.createReservation(reservation);
    }

}
