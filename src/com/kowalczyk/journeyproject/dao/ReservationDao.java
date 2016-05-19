package com.kowalczyk.journeyproject.dao;

import com.kowalczyk.journeyproject.repo.Reservation;

import java.util.List;

/**
 * Created by JK on 2016-05-17.
 */
public interface ReservationDao {
    void insertReservation(Reservation reservation);

    List<Reservation> findAllReservations();

}
