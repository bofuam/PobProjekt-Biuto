package com.kowalczyk.journeyproject.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by JK on 2016-05-12.
 */
public class MainBase {
    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String DB_URL = "jdbc:sqlite:journeyBase.db";
    private Connection connection;
    private Statement statement;

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public MainBase() {
        try{
            Class.forName(MainBase.DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try{
            connection = DriverManager.getConnection(DB_URL);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        createTables();
    }
    public void createTables(){
        try{
            statement.execute(createRelax);
            statement.execute(createSeeing);
            //statement.execute(createAttraction);
            statement.execute(createTour);
            statement.execute(createReservation);
            statement.execute(createBuyTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static final String createRelax = "CREATE TABLE IF NOT EXISTS relax (id_journey INTEGER PRIMARY KEY, name VARCHAR, date VARCHAR, airport VARCHAR, " +
            "hotel VARCHAR, place VARCHAR, pool VARCHAR , golf VARCHAR)";
    private static final String createSeeing = "CREATE TABLE IF NOT EXISTS seeing (id_journey INTEGER PRIMARY KEY, name VARCHAR, date VARCHAR, airport VARCHAR, " +
            "hotel VARCHAR, place VARCHAR, attraction VARCHAR )";
    //private static final String createAttraction = "CREATE TABLE IF NOT EXISTS attraction (id INTEGER PRIMARY KEY, name VARCHAR, about VARCHAR)";
    private static final String createTour = "CREATE TABLE IF NOT EXISTS tour (id_journey INTEGER PRIMARY KEY, name VARCHAR, date VARCHAR, airport VARCHAR, " +
            "hotel VARCHAR, place VARCHAR)";
    private static final String createReservation = "CREATE TABLE IF NOT EXISTS reserv (id_reserv INTEGER PRIMARY KEY, userName VARCHAR," +
            "aboutJourney VARCHAR)";
    private static final String createBuyTable = "CREATE TABLE IF NOT EXISTS buy (id_buy INTEGER PRIMARY KEY, userName VARCHAR, journeyName VARCHAR" +
            "aboutJourney VARCHAR, howMany INTEGER)";
}
