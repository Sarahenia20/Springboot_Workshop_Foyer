package com.example.applicationmaven1.controllers;

import com.example.applicationmaven1.Entities.Foyer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.example.applicationmaven1.Entities.Universite;
import com.example.applicationmaven1.services.IUniversiteService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("api/universites")
@Tag(name = "Gestion Université", description = "API for managing Universités")
public class UniversiteController {

    IUniversiteService universiteService;

    @PostMapping("add")
    @Operation(summary = "Add a new Université", description = "Creates a new Université and returns the created object.")
    public Universite ajoutUniversite(@RequestBody Universite universite) {
        return universiteService.addUniversite(universite);
    }

    @GetMapping("get/{idUniversite}")
    @Operation(summary = "Get Université by ID", description = "Retrieves a Université by its ID.")
    public Universite getUniversite(@PathVariable("idUniversite") long idUniversite) {
        return universiteService.getUniversiteById(idUniversite);
    }

    @DeleteMapping("delete")
    @Operation(summary = "Delete a Université", description = "Deletes a Université based on the provided Université object.")
    public void deleteUniversite(@RequestBody Universite universite) {
        universiteService.deleteUniversite(universite);
    }

    @PutMapping("update")
    @Operation(summary = "Update a Université", description = "Updates an existing Université and returns the updated object.")
    public Universite modifierUniversite(@RequestBody Universite universite) {
        return universiteService.updateUniversite(universite);
    }

    @GetMapping("getalluniversite")
    @Operation(summary = "Get all Universités", description = "Retrieves a list of all Universités.")
    public List<Universite> getAllUniversite() {
        return universiteService.getAllUniversite();
    }

    @PostMapping("/affecterfoyer")
    @Operation(summary = "Affect a Foyer to Université", description = "Assigns a Foyer to a Université and returns the updated Université.")
    public Universite affecterFoyerToUniversite(@RequestBody Universite universite) {
        return universiteService.affecterFoyerToUniversite(universite);
    }

    @PostMapping("/{idUniversite}/affecterfoyer")
    @Operation(summary = "Affect a Foyer to Université", description = "Assigns a Foyer to a Université and returns the updated Université.")
    public ResponseEntity<Universite> affecterFoyerToUni(
            @PathVariable Long idUniversite,
            @RequestBody Foyer foyer) {
        Universite updatedUniversite = universiteService.affecterFoyerToUni(idUniversite, foyer);
        return ResponseEntity.ok(updatedUniversite);
    }
    @PostMapping("/desaffecterFoyer")
    public Universite desaffecterFoyerFromUniversite(@RequestParam Long universiteId) {
        return universiteService.desaffecterFoyerFromUniversite(universiteId);
    }
}