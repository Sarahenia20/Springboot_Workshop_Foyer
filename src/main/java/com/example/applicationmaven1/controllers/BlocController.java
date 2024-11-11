package com.example.applicationmaven1.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.example.applicationmaven1.Entities.Bloc;
import com.example.applicationmaven1.services.IBlocService;
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
@RequestMapping("api/blocs")
@Tag(name = "Gestion Bloc", description = "API for managing Blocs")
public class BlocController {
    IBlocService blocService;

    @PostMapping("addbloc")
    @Operation(summary = "Add a new Bloc", description = "Creates a new Bloc and returns the created object.")
    public Bloc ajoutBloc(@RequestBody Bloc bloc) {
        return blocService.addBloc(bloc);
    }

    @GetMapping("getbloc/{idBloc}")
    @Operation(summary = "Get Bloc by ID", description = "Retrieves a Bloc by its ID.")
    public Bloc getBloc(@PathVariable("idBloc") long idBloc) {
        return blocService.getBlocById(idBloc);
    }

    @DeleteMapping("deletebloc")
    @Operation(summary = "Delete a Bloc", description = "Deletes a Bloc based on the provided Bloc object.")
    public void deleteBloc(@RequestBody Bloc bloc) {
        blocService.deleteBloc(bloc);
    }

    @PutMapping("updatebloc")
    @Operation(summary = "Update a Bloc", description = "Updates an existing Bloc and returns the updated object.")
    public Bloc modifierBloc(@RequestBody Bloc bloc) {
        return blocService.updateBloc(bloc);
    }

    @GetMapping("getallbloc")
    @Operation(summary = "Get all Blocs", description = "Retrieves a list of all Blocs.")
    public List<Bloc> getAllBloc() {
        return blocService.getAllBloc();
    }
    @PostMapping("/add")
    public Bloc ajouterBlocEtChambresAssocie(@RequestBody Bloc bloc) {
        return blocService.ajouterBlocEtChambresAssocie(bloc);
    }
}
