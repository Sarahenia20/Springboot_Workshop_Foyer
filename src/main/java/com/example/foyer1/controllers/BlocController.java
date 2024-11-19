package com.example.foyer1.Controllers;

import com.example.foyer1.Entities.Bloc;
import com.example.foyer1.Services.IBlocService;
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
    public Bloc ajoutBloc(@RequestBody Bloc bloc) {
        return blocService.addBloc(bloc);
    }

    @GetMapping("get/{idBloc}")
    public Bloc getBloc(@PathVariable("idBloc") long idBloc) {
        return blocService.getBlocById(idBloc);
    }

    @DeleteMapping("delete")
    public void deleteBloc(@RequestBody Bloc bloc) {
        blocService.deleteBloc(bloc);
    }

    @PutMapping("updatebloc")
    public Bloc modifierBloc(@RequestBody Bloc bloc) {
        return blocService.updateBloc(bloc);
    }

    @GetMapping("getall")
    public List<Bloc> getAllBloc() {
        return blocService.getAllBloc();
    }


    @PostMapping("ajouterBlocEtChambresAssocie")
    @Operation(description = "Ajouter un bloc avec ses chambres associées")
    public Bloc ajouterBlocEtChambresAssocie(@RequestBody Bloc bloc) {
        return blocService.ajouterBlocEtChambresAssocie(bloc);
    }
    @GetMapping("/byUniversite/{idUniversite}")
    public List<Bloc> getBlocsByUniversite(@PathVariable Long idUniversite) {
        return blocService.getBlocsByUniversiteId(idUniversite);
    }
}

