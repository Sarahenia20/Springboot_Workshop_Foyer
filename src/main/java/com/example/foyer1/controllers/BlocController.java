package com.example.foyer1.controllers;

import com.example.foyer1.entites.bloc;
import com.example.foyer1.services.IBlocService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping("api/blocs")
@Tag(name = "Gestion Bloc")
public class BlocController {
    IBlocService blocService;
    @Operation(description = "ajouter un bloc dans la base de donnees")
    @PostMapping("add")
    public bloc ajoutBloc(@RequestBody bloc bloc) {
        return blocService.addBloc(bloc);
    }

    @GetMapping("get/{idBloc}")
    public bloc getBloc(@PathVariable("idBloc") long idBloc) {
        return blocService.getBlocById(idBloc);
    }

    @DeleteMapping("delete")
    public void deleteBloc(@RequestBody bloc bloc) {
        blocService.deleteBloc(bloc);
    }

    @PutMapping("updatebloc")
    public bloc modifierBloc(@RequestBody bloc bloc) {
        return blocService.updateBloc(bloc);
    }

    @GetMapping("getall")
    public List<bloc> getAllBloc() {
        return blocService.getAllBloc();
    }


    @PostMapping("ajouterBlocEtChambresAssocie")
    @Operation(description = "Ajouter un bloc avec ses chambres associées")
    public bloc ajouterBlocEtChambresAssocie(@RequestBody bloc bloc) {
        return blocService.ajouterBlocEtChambresAssocie(bloc);
    }
    @GetMapping("/byUniversite/{idUniversite}")
    public List<bloc> getBlocsByUniversite(@PathVariable Long idUniversite) {
        return blocService.getBlocsByUniversiteId(idUniversite);
    }
}

