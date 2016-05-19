package com.kowalczyk.journeyproject.impldao;

import com.kowalczyk.journeyproject.repo.Hotel;
import com.kowalczyk.journeyproject.repo.Place;
import com.kowalczyk.journeyproject.repo.TourJourney;
import com.kowalczyk.journeyproject.dao.TourDao;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by JK on 2016-05-16.
 */
public class TourDaoImpl extends BaseDaoImpl implements TourDao {
    public TourDaoImpl(Connection connection, Statement statement) {
        super(connection, statement);
    }
    @Override
    public void insertTour(TourJourney tourJourney) {
        try {
            String sql = "insert into tour values(null, ?, ?, ?, ?, ?)";
            prStatement = prepareStatement.getPreparedStatement(sql, connection);
            prStatement.setString(1, tourJourney.getName());
            prStatement.setString(2, tourJourney.getPlace().getName());
            prStatement.setString(3, tourJourney.getAirport());
            prStatement.setString(4, tourJourney.getHotel().getName());
            prStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TourJourney> findAllTours() {
        tourJourneyList = new LinkedList<>();
        try{
            ResultSet resultSet = statement.executeQuery("SELECT * from tour");
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String placeName = resultSet.getString("place");
                Place place = new Place(placeName);
                String date = resultSet.getString("date");
                String hotelName = resultSet.getString("hotel");
                Hotel hotel = new Hotel(hotelName);
                String airport = resultSet.getString("airport");
                tourJourneyList.add(new TourJourney(name, place, date, hotel, airport, 0));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return tourJourneyList;
    }

    @Override
    public void deleteBoughtTourJourney(TourJourney tourJourney) {
        String sql = "DELETE FROM relax WHERE name = ?";
        prStatement = prepareStatement.getPreparedStatement(sql, connection);
        try {
            prStatement.setString(1, tourJourney.getName());
            prStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<TourJourney> tourJourneyList;
}
