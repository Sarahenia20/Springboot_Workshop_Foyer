package com.example.foyer1.controllers;

import com.example.foyer1.entites.etudiant;
import com.example.foyer1.entites.foyer;
import com.example.foyer1.entites.universite;
import com.example.foyer1.services.IEtudiantService;
import com.example.foyer1.services.IUniversiteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("api/universites")
public class UniversiteController {
    IUniversiteService universiteService;
    @PostMapping("add")
    public universite ajoutUniversite(@RequestBody universite universite) {
        return universiteService.addUniversite(universite);
    }

    @GetMapping("get/{idUniversite}")
    public universite getUniversite(@PathVariable("idUniversite") long idUniversite) {
        return universiteService.getUniversiteById(idUniversite);
    }

    @DeleteMapping("delete")
    public void deleteUniversite(@RequestBody universite universite) {
        universiteService.deleteUniversite(universite);
    }

    @PutMapping("update")
    public universite modifierUniversite(@RequestBody universite universite) {
        return universiteService.updateUniversite(universite);
    }

    @GetMapping("getall")
    public List<universite> getAllUniversite() {
        return universiteService.getAllUniversite();
    }

    @PostMapping("affecterfoyeruniversite")
    public universite affecterFoyerToUniversite(@RequestBody universite universite) {
        return universiteService.affecterFoyerToUniversite(universite);
    }

    @PostMapping("affecterfoyer/{idUniversite}")
    public universite affecterFoyerToUniversite(
            @PathVariable Long idUniversite,
            @RequestBody foyer foyer) {
        return universiteService.affecterFoyerToUniversite(idUniversite, foyer);
    }
    @PutMapping("DesaffecterFoyerFromUniversite/{universiteId}")
    public universite DesaffecterFoyerFromUniversite(@PathVariable("universiteId") Long universiteId) {
        universiteService.DesaffecterFoyerFromUniversite(universiteId);
        return universiteService.getUniversiteById(universiteId);
    }
}
