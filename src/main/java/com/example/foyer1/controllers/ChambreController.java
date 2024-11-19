package com.example.foyer1.controllers;
import com.example.foyer1.entites.chambre;
import com.example.foyer1.entites.typeChambre;
import com.example.foyer1.services.IChambreService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/chambre")
public class ChambreController {
    IChambreService ChambreService;
    @PostMapping("add")
    public chambre ajoutChambre(@RequestBody chambre chambre){
       return ChambreService.addChambre(chambre);    }
    @GetMapping("get/{idChambre}")
    public chambre getChambre(@PathVariable("idChambre") long idChambre) {
        return ChambreService.getChambreById(idChambre);
    }

    @DeleteMapping("delete")
    public void deleteChambre(@RequestBody chambre chambre) {
        ChambreService.deleteChambre(chambre);
    }

    @PutMapping("update")
    public chambre modifierChambre(@RequestBody chambre chambre) {
        return ChambreService.updateChambre(chambre);
    }

    @GetMapping("getall")
    public List<chambre> getAllChambre() {
        return ChambreService.getAllChambre();
    }


    @GetMapping("getByType/{type}")
    public List<chambre> getChambreByType(@PathVariable("type") typeChambre type) {
        return ChambreService.getChambreByType(type);
    }
    @GetMapping("chambrenum/{num}")
    @Operation(summary = "Get all Chambres By Type chambre", description = "Retrieves a list of all Chambres by type.")
    public chambre getByChambreNum(@PathVariable("num") Long num) {
        return ChambreService.findByNumeroChambre(num);
    }
}
