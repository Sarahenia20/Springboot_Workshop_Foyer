package com.example.foyer1.services;



import com.example.foyer1.entites.foyer;

import java.util.List;

public interface IFoyerService {
    foyer addFoyer(foyer foyer);

    foyer getFoyerById(long idFoyer);

    foyer updateFoyer(foyer foyer);

    void deleteFoyer(foyer foyer);

    List<foyer> getAllFoyer();

    void assignBlocToFoyer( Long idBloc, Long idFoyer);
}
