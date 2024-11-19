package com.example.foyer1.Controllers;

import com.example.foyer1.Entities.Foyer;
import com.example.foyer1.Services.IEtudiantService;
import com.example.foyer1.Services.IFoyerService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("api/foyers")
public class FoyerController {
    IFoyerService foyerService;
    @PostMapping("add")
    public Foyer ajoutFoyer(@RequestBody Foyer foyer) {
        return foyerService.addFoyer(foyer);
    }

    @GetMapping("get/{idFoyer}")
    public Foyer getFoyer(@PathVariable("idFoyer") long idFoyer) {
        return foyerService.getFoyerById(idFoyer);
    }

    @DeleteMapping("delete")
    public void deleteFoyer(@RequestBody Foyer foyer) {
        foyerService.deleteFoyer(foyer);
    }

    @PutMapping("update")
    public Foyer modifierFoyer(@RequestBody Foyer foyer) {
        return foyerService.updateFoyer(foyer);
    }

    @GetMapping("getall")
    public List<Foyer> getAllFoyer() {
        return foyerService.getAllFoyer();
    }

    @PutMapping("assignBlocToFoyer/{idBloc}/{idFoyer}")
    public void assignBlocToFoyer(@PathVariable("idBloc") Long idBloc , @PathVariable ("idFoyer") Long idFoyer) {
        foyerService.assignBlocToFoyer(idBloc, idFoyer);
        System.out.println("Bloc assigné avec succes");
    }
}
