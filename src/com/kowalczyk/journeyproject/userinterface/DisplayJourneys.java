package com.kowalczyk.journeyproject.userinterface;

import com.kowalczyk.journeyproject.database.*;
import com.kowalczyk.journeyproject.repo.*;

import java.util.InputMismatchException;
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
    private CheckWhatNumber checkWhatNumber;

    public DisplayJourneys() {
        in = new Scanner(System.in);
        insertJourneys = new InsertJourneys();
        insertJourneys.createBase();
        findTablesDao = new FindTablesDaoImpl();
        checkWhatNumber = new CheckWhatNumber();
    }
    public int displayWelcomeMessage(){
        System.out.println("To see Tour Journeys pick 1, Seeing pick 2, Relax 3, add new journey 4, see reservation 5, bought journeys 6");
        pickedNumber = checkWhatNumber.checkIsNumber();
        return pickedNumber;
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
                displayBuyTables();
                break;
        }
    }

    private void displayBuyTables() {
        findTablesDao.setBuyTableList(insertJourneys.getBuyDai());
        List<BuyTable> buyTableList = findTablesDao.getBuyTableList();
        for(BuyTable bu : buyTableList){
            System.out.println(bu.toString());
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
        if(relaxJourneyList.size() == 0){
            noJourneysList();
        }else{
            for (RelaxJourney rl : relaxJourneyList){
                System.out.println(i + ": " + rl.toString());
                i++;
            }
            checkReservOrBuy(relaxJourneyList);
        }
    }

    private void displayTourJourneys() {
        int i =1;
        findTablesDao.setTourList(insertJourneys.getTourDao());
        List<TourJourney> tourJourneyList = findTablesDao.getTourJourneyList();
        if(tourJourneyList.size() == 0){
            noJourneysList();
        }else{
            for (TourJourney tr : tourJourneyList){
                System.out.println(i + ": " + tr.toString());
                i++;
            }
            checkReservOrBuy(tourJourneyList);
        }
    }

    public void displaySeeingJourneys(){
        int i =1;
        findTablesDao.setSeeingList(insertJourneys.getSeeingDao());
        List<SeeingJourney> seeingJourneyList= findTablesDao.getSeeingJourneyList();
        if(seeingJourneyList.size() == 0){
            noJourneysList();
        }else{
            for (SeeingJourney sj : seeingJourneyList) {
                System.out.println(i + ": " + sj.toString());
                i++;
            }
            checkReservOrBuy(seeingJourneyList);
        }
    }
    public int reservationOrBuy(){
        int number;
        System.out.println("reservation 1, buy journey 2");
        number = checkWhatNumber.checkIsNumber();
        return number;
    }
    public void checkReservOrBuy(List<?> list){
        int number = reservationOrBuy();
        if(number == 1){
            ReservationLogic reservationLogic = new ReservationLogic(list, insertJourneys);
        }else if(number == 2){
            BuyLogic buyLogic = new BuyLogic(list, insertJourneys);
        }
    }
    public void noJourneysList(){
        System.out.println("there are no journey, you have to wait or add new or reserv/buy anotother type");
        checkWhatPicked(displayWelcomeMessage());
    }

}
