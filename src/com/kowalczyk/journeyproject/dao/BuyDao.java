package com.kowalczyk.journeyproject.dao;

import com.kowalczyk.journeyproject.repo.BuyTable;

import java.util.List;

/**
 * Created by JK on 2016-05-17.
 */
public interface BuyDao {
    void insertBuyTable(BuyTable buyTable);

    List<BuyTable> findAllBuyTables();
}
