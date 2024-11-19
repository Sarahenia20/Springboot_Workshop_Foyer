package com.example.foyer1.Controllers;

import com.example.foyer1.Entities.Etudiant;
import com.example.foyer1.Entities.Foyer;
import com.example.foyer1.Entities.Universite;
import com.example.foyer1.Services.IEtudiantService;
import com.example.foyer1.Services.IUniversiteService;
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
    public Universite ajoutUniversite(@RequestBody Universite universite) {
        return universiteService.addUniversite(universite);
    }

    @GetMapping("get/{idUniversite}")
    public Universite getUniversite(@PathVariable("idUniversite") long idUniversite) {
        return universiteService.getUniversiteById(idUniversite);
    }

    @DeleteMapping("delete")
    public void deleteUniversite(@RequestBody Universite universite) {
        universiteService.deleteUniversite(universite);
    }

    @PutMapping("update")
    public Universite modifierUniversite(@RequestBody Universite universite) {
        return universiteService.updateUniversite(universite);
    }

    @GetMapping("getall")
    public List<Universite> getAllUniversite() {
        return universiteService.getAllUniversite();
    }

    @PostMapping("affecterfoyeruniversite")
    public Universite affecterFoyerToUniversite(@RequestBody Universite universite) {
        return universiteService.affecterFoyerToUniversite(universite);
    }

    @PostMapping("affecterfoyer/{idUniversite}")
    public Universite affecterFoyerToUniversite(
            @PathVariable Long idUniversite,
            @RequestBody Foyer foyer) {
        return universiteService.affecterFoyerToUniversite(idUniversite, foyer);
    }
    @PutMapping("DesaffecterFoyerFromUniversite/{universiteId}")
    public Universite DesaffecterFoyerFromUniversite(@PathVariable("universiteId") Long universiteId) {
        universiteService.DesaffecterFoyerFromUniversite(universiteId);
        return universiteService.getUniversiteById(universiteId);
    }
}
