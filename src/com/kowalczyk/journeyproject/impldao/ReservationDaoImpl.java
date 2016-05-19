package com.kowalczyk.journeyproject.impldao;

import com.kowalczyk.journeyproject.repo.Reservation;
import com.kowalczyk.journeyproject.dao.ReservationDao;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by JK on 2016-05-17.
 */
public class ReservationDaoImpl extends BaseDaoImpl implements ReservationDao {
    public ReservationDaoImpl(Connection connection, Statement statement) {
        super(connection, statement);
    }

    @Override
    public void insertReservation(Reservation reservation) {
        try {
            connection.setAutoCommit(true);
            String sql = "INSERT INTO reserv VALUES (NULL , ?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, reservation.getUserName());
            preparedStatement.setString(2, reservation.getAboutJourney());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Reservation> findAllReservations() {
        reservationList = new LinkedList<>();
        String uName;
        String jName;
        String jAbout;
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM reserv");
            while (resultSet.next()){
                uName = resultSet.getString("userName");
                jAbout = resultSet.getString("aboutJourney");
                reservationList.add(new Reservation(uName, jAbout));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return reservationList;
    }
    private List<Reservation> reservationList;
}
