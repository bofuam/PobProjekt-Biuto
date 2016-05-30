package com.kowalczyk.journeyproject.database;

import com.kowalczyk.journeyproject.userinterface.DisplayJourneys;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by JK on 2016-05-19.
 */
public abstract class ReservationBuyLogic {
    private Scanner in ;
    private CheckWhatNumber checkWhatNumber;
    protected List<?> journeyList;
    protected InsertJourneys insertJourneys;
    public ReservationBuyLogic(List<?> journeyList, InsertJourneys insertJourneys) {
        in = new Scanner(System.in);
        this.journeyList = journeyList;
        this.insertJourneys = insertJourneys;
        findWantedJourneyAndSave();
        checkWhatNumber = new CheckWhatNumber();
    }
    public int getWhatJourneyNumber(){
        int number;
        System.out.println("wkich journey? pick number");
        number = in.nextInt();
        System.out.println(number);
        return number;
    }

    public String getNameFromUser(){
        System.out.println("give me your name");
        try {
            in.nextLine();
            String nap = in.nextLine();
            return nap;
        }catch (Exception e){
            System.out.println("wrong input, you will be xxx");
            return "xxx";
        }
    }
    public abstract void findWantedJourneyAndSave();
}
