package com.kowalczyk.journeyproject.dao;

import com.kowalczyk.journeyproject.repo.RelaxJourney;
import com.kowalczyk.journeyproject.repo.SeeingJourney;
import com.kowalczyk.journeyproject.repo.TourJourney;
import com.kowalczyk.journeyproject.impldao.RelaxDaoImpl;
import com.kowalczyk.journeyproject.impldao.SeeingDaoImpl;
import com.kowalczyk.journeyproject.impldao.TourDaoImpl;

/**
 * Created by JK on 2016-05-17.
 */
public interface DeleteDao {
    void deleteTourJourney(TourDaoImpl tourDao, TourJourney tourJourney);

    void deleteSeeingJourney(SeeingDaoImpl seeingDao, SeeingJourney seeingJourney);

    void deleteRelaxJourney(RelaxDaoImpl relaxDao, RelaxJourney relaxJourney);
}
