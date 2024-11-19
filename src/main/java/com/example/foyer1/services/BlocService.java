package com.example.foyer1.Services;

import com.example.foyer1.Entities.Bloc;
import com.example.foyer1.Entities.Chambre;
import com.example.foyer1.Repositories.BlocRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class BlocService implements IBlocService{

    BlocRepository blocRepository;


    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc getBlocById(long idBloc) {
        return blocRepository.findById(idBloc).get();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void deleteBloc(Bloc bloc) { blocRepository.delete(bloc);
    }

    @Override
    public List<Bloc> getAllBloc() {
        return blocRepository.findAll();
    }

// ajouter un Bloc avec les chambres associées

    @Override
    public Bloc ajouterBlocEtChambresAssocie(Bloc bloc) {
        Set<Chambre> chambres = bloc.getChambre();

        if (chambres != null && !chambres.isEmpty()) {
            for (Chambre chambre : chambres) {
                chambre.setBloc(bloc);
            }
        }
  return blocRepository.save(bloc);
    }

    public List<Bloc> getBlocsByUniversiteId(Long idUniversite) {
        return blocRepository.findByFoyerUniversiteIdUniversite(idUniversite);
    }

}
