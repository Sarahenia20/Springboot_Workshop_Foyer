package com.example.foyer1.Services;

import com.example.foyer1.Entities.Bloc;
import com.example.foyer1.Repositories.BlocRepository;

import java.util.List;

public interface IBlocService {
    Bloc addBloc(Bloc bloc);

    Bloc getBlocById(long idBloc);

    Bloc updateBloc(Bloc bloc);

    void deleteBloc(Bloc bloc);

    List<Bloc> getAllBloc();
    Bloc ajouterBlocEtChambresAssocie(Bloc bloc);


    List<Bloc> getBlocsByUniversiteId(Long idUniversite);
}



