package com.kowalczyk.journeyproject.impldao;

import com.kowalczyk.journeyproject.dao.BaseDao;
import com.kowalczyk.journeyproject.database.PrepareStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * Created by JK on 2016-05-16.
 */
public class BaseDaoImpl implements BaseDao {
    protected PreparedStatement prStatement;
    protected PrepareStatement prepareStatement;
    protected Connection connection;
    protected Statement statement;

    public BaseDaoImpl(Connection connection, Statement statement) {
        this.connection = connection;
        this.statement = statement;
        prepareStatement = new PrepareStatement();

    }

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void setStatement(Statement statement) {
        this.statement = statement;
    }
}
