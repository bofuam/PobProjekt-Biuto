package com.kowalczyk.journeyproject.impldao;

import com.kowalczyk.journeyproject.repo.Hotel;
import com.kowalczyk.journeyproject.repo.Place;
import com.kowalczyk.journeyproject.repo.SeeingJourney;
import com.kowalczyk.journeyproject.dao.SeeingDao;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by JK on 2016-05-16.
 */
public class SeeingDaoImpl extends BaseDaoImpl implements SeeingDao {
    public SeeingDaoImpl(Connection connection, Statement statement) {
        super(connection, statement);
    }
    @Override
    public void insertSeeing(SeeingJourney seeingJourney) {
        try {
            String sql = "insert into seeing values(null, ?, ?, ?, ?, ?, ?)";
            prStatement = prepareStatement.getPreparedStatement(sql, connection);
            prStatement.setString(1, seeingJourney.getName());
            prStatement.setString(2, seeingJourney.getDate());
            prStatement.setString(3, seeingJourney.getAirport());
            prStatement.setString(4, seeingJourney.getHotel().getName());
            prStatement.setString(5, seeingJourney.getPlace().getName());
            prStatement.setString(6, seeingJourney.getAttractions());
            prStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<SeeingJourney> findAllSeeings() {
        seeingJourneyList = new LinkedList<>();
        try{
            ResultSet resultSet = statement.executeQuery("SELECT * FROM seeing");
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String placeName = resultSet.getString("place");
                Place place = new Place(placeName);
                String date = resultSet.getString("date");
                String hotelName = resultSet.getString("hotel");
                Hotel hotel = new Hotel(hotelName);
                String airport = resultSet.getString("airport");
                String attractionArrayList =  resultSet.getString("attraction");
                seeingJourneyList.add(new SeeingJourney(name, place, date, hotel, airport, 0, attractionArrayList));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seeingJourneyList;
    }

    @Override
    public void deleteBoughtSeeingJourney(SeeingJourney seeingJourney) {
        String sql = "DELETE FROM seeing WHERE name = ?";
        prStatement = prepareStatement.getPreparedStatement(sql, connection);
        try {
            prStatement.setString(1, seeingJourney.getName());
            prStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<SeeingJourney> seeingJourneyList;
}
