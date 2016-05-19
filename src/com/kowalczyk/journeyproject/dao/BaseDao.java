package com.kowalczyk.journeyproject.dao;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by JK on 2016-05-16.
 */
public interface BaseDao {
    void setConnection(Connection connection);

    void setStatement(Statement statement);
}
