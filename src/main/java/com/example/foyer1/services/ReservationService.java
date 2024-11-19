package com.example.foyer1.services;


import com.example.foyer1.entites.Reservation;
import com.example.foyer1.entites.etudiant;
import com.example.foyer1.repositories.EtudiantRepository;
import com.example.foyer1.repositories.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService{
    ReservationRepository reservationRepository;
    EtudiantRepository etudiantRepository;


    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation getReservationById(int idReservation) {
        return reservationRepository.findById(idReservation).get();
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Reservation reservation) {
        reservationRepository.delete(reservation);
    }

    @Override
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation affecterEtudiantToReservation(Long idetudiant, long idReservation) {
        etudiant etudiant =etudiantRepository.findById(idetudiant).get();
        Reservation reservation= reservationRepository.findById((int) idReservation).get();

        List<etudiant> etudiants = new ArrayList<>();
        if(reservation.getEtudiants()!=null) {
            etudiants = (List<etudiant>) reservation.getEtudiants();
        }
        etudiants.add(etudiant);
        reservation.setEtudiants((Set<etudiant>) etudiants);
        reservationRepository.save(reservation);
        return reservation;
    }

    @Override
    public void desaffecterEtudiantFromReservation(String reservationId, Long etudiantId) {
        Reservation reservation = getReservationById(Integer.valueOf(reservationId));
        etudiant etudiant = etudiantRepository.findById(etudiantId).get();
        reservation.getEtudiants().remove(etudiant);
        reservationRepository.save(reservation);
    }
}
