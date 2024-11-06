package com.example.applicationmaven1.services;

import com.example.applicationmaven1.Entities.Foyer;
import com.example.applicationmaven1.Entities.Universite;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IUniversiteService {
    Universite addUniversite(Universite universite);

    Universite getUniversiteById(long idUniversite);

    Universite updateUniversite(Universite universite);

    void deleteUniversite(Universite universite);

    List<Universite> getAllUniversite();

    Universite affecterFoyerToUniversite(Universite universite);
    Universite affecterFoyerToUni(Long idUniversite, Foyer foyer);
}
