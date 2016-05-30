package com.kowalczyk.journeyproject.impldao;

import com.kowalczyk.journeyproject.repo.BuyTable;
import com.kowalczyk.journeyproject.dao.BuyDao;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by JK on 2016-05-17.
 */
public class BuyDaiImpl extends BaseDaoImpl implements BuyDao {
    public BuyDaiImpl(Connection connection, Statement statement) {
        super(connection, statement);
    }

    @Override
    public void insertBuyTable(BuyTable buyTable) {
        try {
            connection.setAutoCommit(true);
            String sql = "INSERT INTO buy VALUES (null, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, buyTable.getUserName());
            preparedStatement.setString(2, buyTable.getAboutJourney());
            preparedStatement.setInt(3, buyTable.getHowMany());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<BuyTable> findAllBuyTables() {
        buyTableList = new LinkedList<>();
        String uName;
        String jAbout;
        int howMany;
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM buy");
            while (resultSet.next()){
                uName = resultSet.getString("userName");
                jAbout = resultSet.getString("aboutJourney");
                howMany = resultSet.getInt("howMany");
                buyTableList.add(new BuyTable(uName, jAbout, howMany));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return buyTableList;
    }
    private List<BuyTable> buyTableList;
}
