package com.example.foyer1.Services;

import com.example.foyer1.Entities.Universite;
import com.example.foyer1.Entities.Foyer;
import com.example.foyer1.Entities.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite addUniversite(Universite universite);

    Universite getUniversiteById(long idUniversite);

    Universite updateUniversite(Universite universite);

    void deleteUniversite(Universite universite);

    List<Universite> getAllUniversite();
    Universite affecterFoyerToUniversite(Universite universite);

    Universite affecterFoyerToUniversite(Long idUniversite, Foyer foyer);
    Universite DesaffecterFoyerFromUniversite(Long UniversiteId) ;
}