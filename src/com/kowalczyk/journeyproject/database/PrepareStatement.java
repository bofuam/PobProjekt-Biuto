package com.kowalczyk.journeyproject.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by JK on 2016-05-17.
 */
public class PrepareStatement {

    public PreparedStatement getPreparedStatement(String sql, Connection connection) {
        try {
            connection.setAutoCommit(true);
            return connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


}
