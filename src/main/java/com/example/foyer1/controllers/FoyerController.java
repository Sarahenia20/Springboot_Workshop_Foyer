package com.example.foyer1.controllers;

import com.example.foyer1.entites.foyer;
import com.example.foyer1.services.IEtudiantService;
import com.example.foyer1.services.IFoyerService;
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
    public foyer ajoutFoyer(@RequestBody foyer foyer) {
        return foyerService.addFoyer(foyer);
    }

    @GetMapping("get/{idFoyer}")
    public foyer getFoyer(@PathVariable("idFoyer") long idFoyer) {
        return foyerService.getFoyerById(idFoyer);
    }

    @DeleteMapping("delete")
    public void deleteFoyer(@RequestBody foyer foyer) {
        foyerService.deleteFoyer(foyer);
    }

    @PutMapping("update")
    public foyer modifierFoyer(@RequestBody foyer foyer) {
        return foyerService.updateFoyer(foyer);
    }

    @GetMapping("getall")
    public List<foyer> getAllFoyer() {
        return foyerService.getAllFoyer();
    }

    @PutMapping("assignBlocToFoyer/{idBloc}/{idFoyer}")
    public void assignBlocToFoyer(@PathVariable("idBloc") Long idBloc , @PathVariable ("idFoyer") Long idFoyer) {
        foyerService.assignBlocToFoyer(idBloc, idFoyer);
        System.out.println("Bloc assigné avec succes");
    }
}
