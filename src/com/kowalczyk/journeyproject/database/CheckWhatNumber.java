package com.kowalczyk.journeyproject.database;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by JK on 2016-05-30.
 */
public class CheckWhatNumber {
    private Scanner in;

    public CheckWhatNumber() {
        in = new Scanner(System.in);
    }

    public int checkIsNumber(){
        int number = 0;
        do{
            try{
                number = in.nextInt();
            }catch (InputMismatchException e){
                in.nextLine();
                number = 0;
                System.out.println("wrong input, once again");
            }
        }while (number ==0);
        return number;
    }
}
