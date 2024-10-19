package com.example.applicationmaven1.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.example.applicationmaven1.Entities.Foyer;
import com.example.applicationmaven1.services.IFoyerService;
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
@RequestMapping("api/foyers")
@Tag(name = "Gestion Foyer", description = "API for managing Foyers")
public class FoyerController {
    IFoyerService foyerService;

    @PostMapping("addfoyer")
    @Operation(summary = "Add a new Foyer", description = "Creates a new Foyer and returns the created object.")
    public Foyer ajoutFoyer(@RequestBody Foyer foyer) {
        return foyerService.addFoyer(foyer);
    }

    @GetMapping("getfoyer/{idFoyer}")
    @Operation(summary = "Get Foyer by ID", description = "Retrieves a Foyer by its ID.")
    public Foyer getFoyer(@PathVariable("idFoyer") long idFoyer) {
        return foyerService.getFoyerById(idFoyer);
    }

    @DeleteMapping("deletefoyer")
    @Operation(summary = "Delete a Foyer", description = "Deletes a Foyer based on the provided Foyer object.")
    public void deleteFoyer(@RequestBody Foyer foyer) {
        foyerService.deleteFoyer(foyer);
    }

    @PutMapping("updatefoyer")
    @Operation(summary = "Update a Foyer", description = "Updates an existing Foyer and returns the updated object.")
    public Foyer modifierFoyer(@RequestBody Foyer foyer) {
        return foyerService.updateFoyer(foyer);
    }

    @GetMapping("getallfoyer")
    @Operation(summary = "Get all Foyers", description = "Retrieves a list of all Foyers.")
    public List<Foyer> getAllFoyer() {
        return foyerService.getAllFoyer();
    }
}
