package com.example.applicationmaven1.services;

import com.example.applicationmaven1.Entities.Foyer;
import com.example.applicationmaven1.Entities.Universite;
import com.example.applicationmaven1.repositories.FoyerRepository;
import com.example.applicationmaven1.repositories.UniversiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteService implements IUniversiteService {

    UniversiteRepository universiteRepository;
    FoyerRepository foyerRepository;

    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite getUniversiteById(long idUniversite) {
        return universiteRepository.findById(idUniversite).orElseThrow(() ->
                new RuntimeException("Universite not found with id: " + idUniversite));
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public void deleteUniversite(Universite universite) {
        universiteRepository.delete(universite);
    }

    @Override
    public List<Universite> getAllUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite affecterFoyerToUniversite(Universite universite) {
        // Since the cascade is set to ALL, persisting Universite will also persist Foyer
        return universiteRepository.save(universite);
    }

    @Override
    public Universite affecterFoyerToUni(Long idUniversite, Foyer foyer) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new RuntimeException("Universite not found with id: " + idUniversite));

        foyer.setUniversite(universite);

        foyerRepository.save(foyer);


        return universite;
    }


}
