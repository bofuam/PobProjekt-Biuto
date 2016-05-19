package com.kowalczyk.journeyproject.userinterface;

import com.kowalczyk.journeyproject.database.AddNewJourneyDaoImpl;
import com.kowalczyk.journeyproject.database.FindTablesDaoImpl;
import com.kowalczyk.journeyproject.database.InsertJourneys;
import com.kowalczyk.journeyproject.database.ReservationLogic;
import com.kowalczyk.journeyproject.repo.RelaxJourney;
import com.kowalczyk.journeyproject.repo.Reservation;
import com.kowalczyk.journeyproject.repo.SeeingJourney;
import com.kowalczyk.journeyproject.repo.TourJourney;

import java.util.List;
import java.util.Scanner;

/**
 * Created by JK on 2016-05-17.
 */
public class DisplayJourneys {
    private int pickedNumber;
    private InsertJourneys insertJourneys;
    private FindTablesDaoImpl findTablesDao;
    private Scanner in;
    public DisplayJourneys() {
        in = new Scanner(System.in);
        insertJourneys = new InsertJourneys();
        insertJourneys.createBase();
        findTablesDao = new FindTablesDaoImpl();
    }
    public int displayWelcomeMessage(){
        System.out.println("Hello, To see Tour Journeys pick 1, Seeing pick 2, Relax 3, add new journey 4, see reservation 5, bought journeys 6");
        return pickedNumber = in.nextInt();
    }
    public void checkWhatPicked(int picked){
        switch (picked){
            case 1:
                displayTourJourneys();
                break;
            case 2:
                displaySeeingJourneys();
                break;
            case 3:
                displayRelaxJourneys();
                break;
            case 4:
                callAddNewJourney();
                break;
            case 5:
                displayReservations();
                break;
            case 6:

                break;
        }
    }

    private void displayReservations() {
        findTablesDao.setReservationList(insertJourneys.getReservationDao());
        List<Reservation> reservationList = findTablesDao.getReservationList();
        for(Reservation re: reservationList){
            System.out.println(re.toString());
        }
    }

    private void callAddNewJourney() {
        AddNewJourneyDaoImpl addNewJourney = new AddNewJourneyDaoImpl(insertJourneys);
        addNewJourney.displayWhatJourneyType();
    }

    private void displayRelaxJourneys() {
        findTablesDao.setRelaxList(insertJourneys.getRelaxDao());
        int i =1;
        List<RelaxJourney> relaxJourneyList = findTablesDao.getRelaxJourneyList();
        for (RelaxJourney rl : relaxJourneyList){
            System.out.println(i + ": " + rl.toString());
            i++;
        }
        checkReservOrBuy(relaxJourneyList);
    }

    private void displayTourJourneys() {
        int i =1;
        findTablesDao.setTourList(insertJourneys.getTourDao());
        List<TourJourney> tourJourneyList = findTablesDao.getTourJourneyList();
        for (TourJourney tr : tourJourneyList){
            System.out.println(i + ": " + tr.toString());
            i++;
        }
        checkReservOrBuy(tourJourneyList);
    }

    public void displaySeeingJourneys(){
        int i =1;
        findTablesDao.setSeeingList(insertJourneys.getSeeingDao());
        List<SeeingJourney> seeingJourneyList= findTablesDao.getSeeingJourneyList();
        for (SeeingJourney sj : seeingJourneyList) {
            System.out.println(i + ": " + sj.toString());
            i++;
        }
        checkReservOrBuy(seeingJourneyList);
    }
    public int reservationOrBuy(){
        System.out.println("reservation 1, buy journey 2");
        return in.nextInt();
    }
    public void checkReservOrBuy(List<?> list){
        if(reservationOrBuy() == 1){
            ReservationLogic reservationLogic = new ReservationLogic(list, insertJourneys);
        }else if(reservationOrBuy() == 2){

        }
    }
}
