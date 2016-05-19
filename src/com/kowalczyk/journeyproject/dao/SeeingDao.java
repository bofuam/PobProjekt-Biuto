package com.kowalczyk.journeyproject.dao;

import com.kowalczyk.journeyproject.repo.SeeingJourney;

import java.util.List;

/**
 * Created by JK on 2016-05-16.
 */
public interface SeeingDao {
    void insertSeeing(SeeingJourney seeingJourney);
    List<SeeingJourney> findAllSeeings();

    void deleteBoughtSeeingJourney(SeeingJourney seeingJourney);
}
