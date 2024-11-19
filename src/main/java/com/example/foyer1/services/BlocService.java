package com.example.foyer1.services;

import com.example.foyer1.entites.bloc;
import com.example.foyer1.entites.bloc;
import com.example.foyer1.entites.chambre;
import com.example.foyer1.entites.foyer;
import com.example.foyer1.repositories.BlocRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class BlocService implements IBlocService{

    BlocRepository blocRepository;


    @Override
    public bloc addBloc(bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public bloc getBlocById(long idBloc) {
        return blocRepository.findById(idBloc).get();
    }

    @Override
    public bloc updateBloc(bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void deleteBloc(bloc bloc) { blocRepository.delete(bloc);
    }

    @Override
    public List<bloc> getAllBloc() {
        return blocRepository.findAll();
    }

// ajouter un Bloc avec les chambres associées

    @Override
    public bloc ajouterBlocEtChambresAssocie(bloc bloc) {
        Set<chambre> chambres = bloc.getChambres();

        if (chambres != null && !chambres.isEmpty()) {
            for (chambre chambre : chambres) {
                chambre.setBloc(bloc);
            }
        }
  return blocRepository.save(bloc);
    }

    public List<bloc> getBlocsByUniversiteId(Long idUniversite) {
        return blocRepository.findByFoyerUniversiteIdUniversite(idUniversite);
    }

}
