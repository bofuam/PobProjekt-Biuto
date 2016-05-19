package com.kowalczyk;

import com.kowalczyk.journeyproject.database.CreateFirstOneBase;
import com.kowalczyk.journeyproject.userinterface.DisplayJourneys;

/**
 * Created by JK on 2016-05-12.
 */
public class Main {
    public static void main(String[] args) {
       // CreateFirstOneBase createFirstOneBase = new CreateFirstOneBase();
        DisplayJourneys displayJourneys = new DisplayJourneys();
        int number = displayJourneys.displayWelcomeMessage();
        displayJourneys.checkWhatPicked(number);
    }
}
