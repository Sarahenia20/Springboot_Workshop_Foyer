package com.example.foyer1.Controllers;
import com.example.foyer1.Entities.Chambre;
import com.example.foyer1.Entities.TypeChambre;
import com.example.foyer1.Services.IChambreService;
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
    public Chambre ajoutChambre(@RequestBody Chambre chambre){
       return ChambreService.addChambre(chambre);    }
    @GetMapping("get/{idChambre}")
    public Chambre getChambre(@PathVariable("idChambre") long idChambre) {
        return ChambreService.getChambreById(idChambre);
    }

    @DeleteMapping("delete")
    public void deleteChambre(@RequestBody Chambre chambre) {
        ChambreService.deleteChambre(chambre);
    }

    @PutMapping("update")
    public Chambre modifierChambre(@RequestBody Chambre chambre) {
        return ChambreService.updateChambre(chambre);
    }

    @GetMapping("getall")
    public List<Chambre> getAllChambre() {
        return ChambreService.getAllChambre();
    }


    @GetMapping("getByType/{type}")
    public List<Chambre> getChambreByType(@PathVariable("type") TypeChambre type) {
        return ChambreService.getChambreByType(type);
    }
    @GetMapping("chambrenum/{num}")
    @Operation(summary = "Get all Chambres By Type chambre", description = "Retrieves a list of all Chambres by type.")
    public Chambre getByChambreNum(@PathVariable("num") Long num) {
        return ChambreService.findByNumeroChambre(num);
    }
}
