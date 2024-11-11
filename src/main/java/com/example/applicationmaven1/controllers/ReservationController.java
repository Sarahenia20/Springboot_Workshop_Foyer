package com.example.applicationmaven1.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.example.applicationmaven1.Entities.Reservation;
import com.example.applicationmaven1.services.IReservationService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("api/reservations")
@Tag(name = "Gestion Réservation", description = "API for managing Reservations")
public class ReservationController {
    IReservationService reservationService;

    @PostMapping("addreservation")
    @Operation(summary = "Add a new Reservation", description = "Creates a new Reservation and returns the created object.")
    public Reservation ajoutReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @GetMapping("getreservation/{idReservation}")
    @Operation(summary = "Get Reservation by ID", description = "Retrieves a Reservation by its ID.")
    public Reservation getReservation(@PathVariable("idReservation") int idReservation) {
        return reservationService.getReservationById(idReservation);
    }

    @DeleteMapping("deletereservation")
    @Operation(summary = "Delete a Reservation", description = "Deletes a Reservation based on the provided Reservation object.")
    public void deleteReservation(@RequestBody Reservation reservation) {
        reservationService.deleteReservation(reservation);
    }

    @PutMapping("updatereservation")
    @Operation(summary = "Update a Reservation", description = "Updates an existing Reservation and returns the updated object.")
    public Reservation modifierReservation(@RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }

    @GetMapping("getallreservation")
    @Operation(summary = "Get all Reservations", description = "Retrieves a list of all Reservations.")
    public List<Reservation> getAllReservation() {
        return reservationService.getAllReservation();
    }
    @PostMapping("/assignEtudiant")
    public Reservation assignEtudiantToReservation(
            @RequestParam Long idReservation,
            @RequestParam Long idEtudiant) {
        return reservationService.affecterEtudiantToReservation(idReservation, idEtudiant);
    }
    // Endpoint to remove an Etudiant from a Reservation
    @DeleteMapping("/removeEtudiant")
    public String removeEtudiantFromReservation(
            @RequestParam Long idReservation,
            @RequestParam Long idEtudiant) {
        try {
            reservationService.desaffecterEtudiantFromReservation(idReservation, idEtudiant);
            return "Etudiant successfully removed from Reservation.";
        } catch (RuntimeException e) {
            return "Error: " + e.getMessage();
        }
    }
}