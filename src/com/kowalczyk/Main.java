package com.kowalczyk;

import com.kowalczyk.journeyproject.database.CreateFirstOneBase;
import com.kowalczyk.journeyproject.userinterface.DisplayJourneys;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by JK on 2016-05-12.
 */
public class Main {
    public static void main(String[] args) {
        try{
            FileReader file = new FileReader("journeyBase.db");
        } catch (FileNotFoundException e) {
            CreateFirstOneBase createFirstOneBase = new CreateFirstOneBase();
        }
        Scanner in = new Scanner(System.in);
        do {
            DisplayJourneys displayJourneys = new DisplayJourneys();
            int number = displayJourneys.displayWelcomeMessage();
            displayJourneys.checkWhatPicked(number);
            System.out.println("1-end, 2 - nexy option");
        }while (in.nextInt() != 1);

    }
}
