package com.example.applicationmaven1.services;


import com.example.applicationmaven1.Entities.Etudiant;
import com.example.applicationmaven1.Entities.Reservation;
import com.example.applicationmaven1.repositories.EtudiantRepository;
import com.example.applicationmaven1.repositories.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {
    ReservationRepository reservationRepository;
    private EtudiantRepository etudiantRepository;

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation getReservationById(int idReservation) {
        return reservationRepository.findById((long) idReservation).get();
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
    public Reservation affecterEtudiantToReservation(Long idReservation, Long idEtudiant) {
        // Find the reservation
        Optional<Reservation> reservationOpt = reservationRepository.findById(idReservation);
        if (reservationOpt.isEmpty()) {
            throw new RuntimeException("Reservation not found");
        }

        // Find the student
        Optional<Etudiant> etudiantOpt = etudiantRepository.findById(idEtudiant);
        if (etudiantOpt.isEmpty()) {
            throw new RuntimeException("Etudiant not found");
        }

        Reservation reservation = reservationOpt.get();
        Etudiant etudiant = etudiantOpt.get();

        // Add the student to the reservation
        reservation.getEtudiants().add(etudiant);
        etudiant.getReservations().add(reservation);

        // Save both entities
        reservationRepository.save(reservation);
        etudiantRepository.save(etudiant);

        return reservation;
    }
    @Override
    public void desaffecterEtudiantFromReservation(Long idReservation, Long idEtudiant) {
        // Fetch the reservation by ID
        Optional<Reservation> reservationOpt = reservationRepository.findById(idReservation);
        if (reservationOpt.isEmpty()) {
            throw new RuntimeException("Reservation not found");
        }

        // Fetch the student by ID
        Optional<Etudiant> etudiantOpt = etudiantRepository.findById(idEtudiant);
        if (etudiantOpt.isEmpty()) {
            throw new RuntimeException("Etudiant not found");
        }

        Reservation reservation = reservationOpt.get();
        Etudiant etudiant = etudiantOpt.get();

        // Remove the association
        reservation.getEtudiants().remove(etudiant);
        etudiant.getReservations().remove(reservation);

        // Save both entities
        reservationRepository.save(reservation);
        etudiantRepository.save(etudiant);
    }
}