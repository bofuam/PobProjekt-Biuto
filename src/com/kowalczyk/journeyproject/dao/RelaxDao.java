package com.kowalczyk.journeyproject.dao;

import com.kowalczyk.journeyproject.repo.RelaxJourney;


import java.util.List;

/**
 * Created by JK on 2016-05-12.
 */
public interface RelaxDao {
    void insertRelax(RelaxJourney relaxJourney);
    List<RelaxJourney> findAllRelaxes();
    void deleteBoughtJourney(RelaxJourney relaxJourney);
}
