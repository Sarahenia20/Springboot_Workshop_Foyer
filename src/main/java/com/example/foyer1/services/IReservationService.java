package com.example.foyer1.Services;

import com.example.foyer1.Entities.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation addReservation(Reservation reservation);

    Reservation getReservationById(int idReservation);

    Reservation updateReservation(Reservation reservation);

    void deleteReservation(Reservation reservation);

    List<Reservation> getAllReservation();

    Reservation affecterEtudiantToReservation(Long idetudiant, long idReservation);
    void desaffecterEtudiantFromReservation(String reservationId, Long etudiantId) ;

}
