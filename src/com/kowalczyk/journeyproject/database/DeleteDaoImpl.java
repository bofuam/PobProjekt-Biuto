package com.kowalczyk.journeyproject.database;

import com.kowalczyk.journeyproject.repo.RelaxJourney;
import com.kowalczyk.journeyproject.repo.SeeingJourney;
import com.kowalczyk.journeyproject.repo.TourJourney;
import com.kowalczyk.journeyproject.dao.DeleteDao;
import com.kowalczyk.journeyproject.impldao.RelaxDaoImpl;
import com.kowalczyk.journeyproject.impldao.SeeingDaoImpl;
import com.kowalczyk.journeyproject.impldao.TourDaoImpl;

/**
 * Created by JK on 2016-05-17.
 */
public class DeleteDaoImpl implements DeleteDao {
    @Override
    public void deleteTourJourney(TourDaoImpl tourDao, TourJourney tourJourney) {
        tourDao.deleteBoughtTourJourney(tourJourney);
    }

    @Override
    public void deleteSeeingJourney(SeeingDaoImpl seeingDao, SeeingJourney seeingJourney) {
        seeingDao.deleteBoughtSeeingJourney(seeingJourney);
    }

    @Override
    public void deleteRelaxJourney(RelaxDaoImpl relaxDao, RelaxJourney relaxJourney) {
        relaxDao.deleteBoughtJourney(relaxJourney);
    }
}
