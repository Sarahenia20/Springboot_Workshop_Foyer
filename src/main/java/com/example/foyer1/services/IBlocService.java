package com.example.foyer1.services;

import com.example.foyer1.entites.bloc;
import com.example.foyer1.repositories.BlocRepository;

import java.util.List;

public interface IBlocService {
    bloc addBloc(bloc bloc);

    bloc getBlocById(long idBloc);

    bloc updateBloc(bloc bloc);

    void deleteBloc(bloc bloc);

    List<bloc> getAllBloc();
    bloc ajouterBlocEtChambresAssocie(bloc bloc);


    List<bloc> getBlocsByUniversiteId(Long idUniversite);
}



