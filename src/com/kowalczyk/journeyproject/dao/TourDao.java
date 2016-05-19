package com.kowalczyk.journeyproject.dao;

import com.kowalczyk.journeyproject.repo.TourJourney;

import java.util.List;

/**
 * Created by JK on 2016-05-16.
 */
public interface TourDao {
    void insertTour(TourJourney tourJourney);

    List<TourJourney> findAllTours();

    void deleteBoughtTourJourney(TourJourney tourJourney);
}
