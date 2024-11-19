package com.example.foyer1.Services;


import com.example.foyer1.Entities.Reservation;
import com.example.foyer1.Entities.Etudiant;
import com.example.foyer1.Repositories.EtudiantRepository;
import com.example.foyer1.Repositories.ReservationRepository;
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
        Etudiant etudiant =etudiantRepository.findById(idetudiant).get();
        Reservation reservation= reservationRepository.findById((int) idReservation).get();

        List<Etudiant> etudiants = new ArrayList<>();
        if(reservation.getEtudiants()!=null) {
            etudiants = (List<Etudiant>) reservation.getEtudiants();
        }
        etudiants.add(etudiant);
        reservation.setEtudiants((Set<Etudiant>) etudiants);
        reservationRepository.save(reservation);
        return reservation;
    }

    @Override
    public void desaffecterEtudiantFromReservation(String reservationId, Long etudiantId) {
        Reservation reservation = getReservationById(Integer.valueOf(reservationId));
        Etudiant etudiant = etudiantRepository.findById(etudiantId).get();
        reservation.getEtudiants().remove(etudiant);
        reservationRepository.save(reservation);
    }
}
