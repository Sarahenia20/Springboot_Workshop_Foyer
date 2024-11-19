package com.example.foyer1.services;

import com.example.foyer1.entites.foyer;
import com.example.foyer1.entites.universite;

import java.util.List;

public interface IUniversiteService {
    universite addUniversite(universite universite);

    universite getUniversiteById(long idUniversite);

    universite updateUniversite(universite universite);

    void deleteUniversite(universite universite);

    List<universite> getAllUniversite();
    universite affecterFoyerToUniversite(universite universite);

    universite affecterFoyerToUniversite(Long idUniversite, foyer foyer);
    universite DesaffecterFoyerFromUniversite(Long UniversiteId) ;
}