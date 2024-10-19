package com.example.applicationmaven1.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.example.applicationmaven1.Entities.Etudiant;
import com.example.applicationmaven1.services.IEtudiantService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("api/etudiants")
@Tag(name = "Gestion Étudiant", description = "API for managing Étudiants")
public class EtudiantController {
    @Qualifier("etudiantServiceImpl")
    IEtudiantService etudiantService;

    @PostMapping("addetudiant")
    @Operation(summary = "Add a new Étudiant", description = "Creates a new Étudiant and returns the created object.")
    public Etudiant ajoutEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.addEtudiant(etudiant);
    }

    @GetMapping("getetudiant/{idEtudiant}")
    @Operation(summary = "Get Étudiant by ID", description = "Retrieves an Étudiant by its ID.")
    public Etudiant getEtudiant(@PathVariable("idEtudiant") long idEtudiant) {
        return etudiantService.getEtudiantById(idEtudiant);
    }

    @DeleteMapping("deleteetudiant")
    @Operation(summary = "Delete an Étudiant", description = "Deletes an Étudiant based on the provided Étudiant object.")
    public void deleteEtudiant(@RequestBody Etudiant etudiant) {
        etudiantService.deleteEtudiant(etudiant);
    }

    @PutMapping("updateetudiant")
    @Operation(summary = "Update an Étudiant", description = "Updates an existing Étudiant and returns the updated object.")
    public Etudiant modifierEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.updateEtudiant(etudiant);
    }

    @GetMapping("getalletudiant")
    @Operation(summary = "Get all Étudiants", description = "Retrieves a list of all Étudiants.")
    public List<Etudiant> getAllEtudiant() {
        return etudiantService.getAllEtudiant();
    }
}
