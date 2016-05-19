package com.kowalczyk.journeyproject.repo;

/**
 * Created by JK on 2016-05-17.
 */
public class BuyTable extends Reservation{
    private int howMany;

    public BuyTable(String userName, String aboutJourney, int howMany) {
        super(userName,  aboutJourney);
        this.howMany = howMany;
    }

    public BuyTable() {
    }

    public int getHowMany() {
        return howMany;
    }

    public void setHowMany(int howMany) {
        this.howMany = howMany;
    }
}
