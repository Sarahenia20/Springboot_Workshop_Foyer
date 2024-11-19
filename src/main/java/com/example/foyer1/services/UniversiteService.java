package com.example.foyer1.services;


import com.example.foyer1.entites.foyer;
import com.example.foyer1.entites.universite;
import com.example.foyer1.repositories.UniversiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteService implements IUniversiteService{
    UniversiteRepository universiteRepository;


    @Override
    public universite addUniversite(universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public universite getUniversiteById(long idUniversite) {
        return universiteRepository.findById(idUniversite).get();
    }

    @Override
    public universite updateUniversite(universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public void deleteUniversite(universite universite) {
        universiteRepository.delete(universite);
    }

    @Override
    public List<universite> getAllUniversite() {
        return universiteRepository.findAll();
    }
    @Override
    public universite affecterFoyerToUniversite(universite universite) {
        // Vérifier si l'université a un foyer associé
        if (universite.getFoyer() != null) {
            foyer foyerAssocie = universite.getFoyer();

            // Sauvegarder l'université avec son foyer (grâce à CascadeType.ALL)
            universite.setFoyer(foyerAssocie);
        }
        return universiteRepository.save(universite);
    }

    @Override
    public universite affecterFoyerToUniversite(Long idUniversite, foyer foyer) {
        // Récupérer l'université par son ID
        universite universiteExistante = universiteRepository.findById(idUniversite).orElse(null);

        if (universiteExistante != null) {
            // Affecter le foyer à l'université
            universiteExistante.setFoyer(foyer);

            // Sauvegarder l'université avec le foyer
            return universiteRepository.save(universiteExistante);
        }

        // Si l'université n'existe pas, retourner null ou lever une exception
        return null;
    }
    @Override
    public universite DesaffecterFoyerFromUniversite(Long universiteId){
        universite universite = universiteRepository.findById(universiteId).get();
        universite.setFoyer(null);
        universiteRepository.save(universite);
        return universite;
    }
}
