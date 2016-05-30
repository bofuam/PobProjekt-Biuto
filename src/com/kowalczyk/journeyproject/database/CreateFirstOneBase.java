package com.kowalczyk.journeyproject.database;

import com.kowalczyk.journeyproject.repo.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JK on 2016-05-16.
 */
public class CreateFirstOneBase {
    public CreateFirstOneBase() {
        InsertJourneys insertJourneys = new InsertJourneys();
        insertJourneys.createBase();
        insertJourneys.setConnectionAndStatemnt();
        insertJourneys.createDaosImpls();
        List<RelaxJourney> relaxJourneyList = new ArrayList<>();
        Place place1 = new Place("hiszpania");
        Place place2 = new Place("polska");
        Hotel hotel1 = new Hotel("Duzy");
        Hotel hotel2 = new Hotel("Dobry");
        relaxJourneyList.add(new RelaxJourney("hiszpania", place1, "29.02", hotel2, "warszawa", 24, "tak", "tak"));
        relaxJourneyList.add(new RelaxJourney("kolobrzeg", place2, "43-4", hotel1, "poznan", 33, "nie", "nie"));
        relaxJourneyList.forEach(insertJourneys::createRelaxJourney);
        Place placesforTour = new Place("Hiszpania, mania, kloldad");
        Hotel hotelsfourTour = new Hotel("baltyk, duzy, maluy");
        List<TourJourney> tourJourneys = new ArrayList<>();
        tourJourneys.add(new TourJourney("hiszpania", placesforTour, "34-32", hotelsfourTour, "modlin", 5000));
        tourJourneys.forEach(insertJourneys::createTourJourney);
        List<SeeingJourney> seeingJourneyList = new ArrayList<>();
        seeingJourneyList.add(new SeeingJourney("polska", place1, "42", hotel1, "berlin", 32, "duzo atrakcji takich jak katedra, zamek, plaza, cos"));
        seeingJourneyList.add(new SeeingJourney("alaska", place1, "4", hotel1, "lin", 32, "duzo atjak katedra, z plaza, cos"));
        seeingJourneyList.forEach(insertJourneys::createSeeingJourney);
    }
}
