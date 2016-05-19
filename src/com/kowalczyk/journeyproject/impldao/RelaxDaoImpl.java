package com.kowalczyk.journeyproject.impldao;

import com.kowalczyk.journeyproject.repo.Hotel;
import com.kowalczyk.journeyproject.repo.Place;
import com.kowalczyk.journeyproject.repo.RelaxJourney;
import com.kowalczyk.journeyproject.dao.RelaxDao;


import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by JK on 2016-05-12.
 */
public class RelaxDaoImpl extends BaseDaoImpl implements RelaxDao{

    public RelaxDaoImpl(Connection connection, Statement statement) {
        super(connection, statement);
    }
    @Override
    public void insertRelax(RelaxJourney relaxJourney) {
            String sql = "insert into relax values(null, ?, ?, ?, ?, ?, ?, ?)";
            prStatement = prepareStatement.getPreparedStatement(sql, connection);
        try {
            prStatement.setString(1, relaxJourney.getName());
            prStatement.setString(2, relaxJourney.getDate());
            prStatement.setString(3, relaxJourney.getAirport());
            prStatement.setString(4, relaxJourney.getPlace().getName());
            prStatement.setString(5, relaxJourney.getHotel().getName());
            prStatement.setString(6, relaxJourney.isGolf());
            prStatement.setString(7, relaxJourney.isPool());
            prStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<RelaxJourney> findAllRelaxes() {
        relaxJourneyList = new LinkedList<>();
        try{
            ResultSet resultSet = statement.executeQuery("SELECT * from relax");
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String placeName = resultSet.getString("place");
                Place place = new Place(placeName);
                String date = resultSet.getString("date");
                String hotelName = resultSet.getString("hotel");
                Hotel hotel = new Hotel(hotelName);
                String airport = resultSet.getString("airport");
                String pool = resultSet.getString("pool");
                String golf = resultSet.getString("golf");
                relaxJourneyList.add(new RelaxJourney(name, place, date, hotel, airport, 0, pool,golf));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return relaxJourneyList;
    }

    private List<RelaxJourney> relaxJourneyList;

    @Override
    public void deleteBoughtJourney(RelaxJourney relaxJourney) {
        String sql = "DELETE FROM relax WHERE name = ?";
        prStatement = prepareStatement.getPreparedStatement(sql, connection);
        try {
            prStatement.setString(1, relaxJourney.getName());
            prStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
