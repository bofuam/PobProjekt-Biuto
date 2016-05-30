package com.kowalczyk.journeyproject.database;

import com.kowalczyk.journeyproject.repo.*;

import java.util.List;
import java.util.Scanner;

/**
 * Created by JK on 2016-05-19.
 */
public class BuyLogic extends ReservationBuyLogic {
    private Journey journey;
    public BuyLogic(List<?> journeyList, InsertJourneys insertJourneys) {
        super(journeyList, insertJourneys);
    }

    @Override
    public void findWantedJourneyAndSave() {
        int number = getWhatJourneyNumber() - 1;
        journey = (Journey) this.journeyList.get(number);
        BuyTable buyTable = new BuyTable(getNameFromUser(), journey.toString(), howMany());
        insertJourneys.createBuyTable(buyTable);
        deleteBoughtJourney();
    }
    public int howMany(){
        System.out.println("for how many persons you want to buyy?");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
    public void deleteBoughtJourney(){
        if(journey instanceof SeeingJourney){
            insertJourneys.deleteSeeingJourney((SeeingJourney) journey);
        }else if (journey instanceof TourJourney){
            insertJourneys.deleteTourJourney((TourJourney) journey);
        }else if(journey instanceof RelaxJourney){
            insertJourneys.deleteRelaxJourney((RelaxJourney) journey);
        }
    }
}
