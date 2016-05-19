package com.kowalczyk.journeyproject.database;

import com.kowalczyk.journeyproject.dao.AddNewJourneyDao;
import com.kowalczyk.journeyproject.repo.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by JK on 2016-05-18.
 */
public class AddNewJourneyDaoImpl implements AddNewJourneyDao {
    private TourJourney tourJourney;
    private SeeingJourney seeingJourney;
    private RelaxJourney relaxJourney;
    private InsertJourneys insertJourneys;
    private Scanner in;
    public AddNewJourneyDaoImpl(InsertJourneys insertJourneys) {
        this.insertJourneys = insertJourneys;
    }

    @Override
    public void displayWhatJourneyType() {
        System.out.println("what journey you want to add? 1 - seeing, 2-relax, 3- tour");
        in = new Scanner(System.in);
        checkWhatJourneyType();
    }

    @Override
    public void checkWhatJourneyType() {
        Scanner in = new Scanner(System.in);
        int whatNumber = in.nextInt();
        switch (whatNumber){
            case 1 :
                getSeeingJourneyFromUser();
                break;
            case 2:
                getRelaxJourneyFromUser();
                break;
            case 3:
                getTourJourneyFromUser();
                break;
        }
    }

    @Override
    public void getTourJourneyFromUser() {
        String[] strings = getTourFromUser();
        int price = getPrice();
        tourJourney = new TourJourney(strings[0], new Place(strings[1]), strings[2], new Hotel(strings[3]), strings[4], price);
        saveTourJourney();
    }

    @Override
    public void getSeeingJourneyFromUser() {
        String[] strings = getTourFromUser();
        int price = getPrice();
        in.nextLine();
        System.out.println("Attrakcje: ");
        String attractions = in.nextLine();
        seeingJourney = new SeeingJourney(strings[0], new Place(strings[1]), strings[2], new Hotel(strings[3]), strings[4], price, attractions);
        saveSeeingJourney();
    }

    @Override
    public void getRelaxJourneyFromUser() {
        String[] strings = getTourFromUser();
        int price = getPrice();
        System.out.println("pool: ");
        String pool = in.next();
        System.out.println("golf: ");
        String golf = in.next();
        relaxJourney = new RelaxJourney(strings[0], new Place(strings[1]), strings[2], new Hotel(strings[3]), strings[4], price, pool, golf);
        saveRelaxJourney();
    }

    @Override
    public void saveTourJourney() {
        insertJourneys.createTourJourney(tourJourney);
    }

    @Override
    public void saveSeeingJourney() {
        insertJourneys.createSeeingJourney(seeingJourney);
    }

    @Override
    public void saveRelaxJourney() {
        insertJourneys.createRelaxJourney(relaxJourney);
    }

    @Override
    public String[] getTourFromUser() {
        String[] strings = new String[5];
        String[] names = {"name: ", "places: ", "data: ", "hotels: " , "airport:" , "price:"};
        for (int i = 0 ; i< 5; i++){
            System.out.println(names[i]);
            strings[i] = in.nextLine();
        }
        return strings;
    }

    @Override
    public int getPrice() {
        System.out.println("price: ");
        int price = in.nextInt();
        return price;
    }
}
