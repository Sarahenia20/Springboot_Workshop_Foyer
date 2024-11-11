package com.example.applicationmaven1.services;

import com.example.applicationmaven1.Entities.Foyer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IFoyerService {
    Foyer addFoyer(Foyer foyer);

    Foyer getFoyerById(long idFoyer);

    Foyer updateFoyer(Foyer foyer);

    void deleteFoyer(Foyer foyer);

    List<Foyer> getAllFoyer();
    void assignBlocToFoyer(Long idBloc, Long idFoyer);
}
