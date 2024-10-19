package com.example.applicationmaven1.services;

import com.example.applicationmaven1.Entities.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IReservationService {
    Reservation addReservation(Reservation reservation);

    Reservation getReservationById(int idReservation);

    Reservation updateReservation(Reservation reservation);

    void deleteReservation(Reservation reservation);

    List<Reservation> getAllReservation();
}
