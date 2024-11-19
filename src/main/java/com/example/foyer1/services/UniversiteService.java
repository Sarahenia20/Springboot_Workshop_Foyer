package com.example.foyer1.Services;


import com.example.foyer1.Entities.Foyer;
import com.example.foyer1.Entities.Universite;
import com.example.foyer1.Repositories.UniversiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteService implements IUniversiteService{
    UniversiteRepository universiteRepository;


    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite getUniversiteById(long idUniversite) {
        return universiteRepository.findById(idUniversite).get();
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
        // Vérifier si l'université a un foyer associé
        if (universite.getFoyer() != null) {
            Foyer foyerAssocie = universite.getFoyer();

            // Sauvegarder l'université avec son foyer (grâce à CascadeType.ALL)
            universite.setFoyer(foyerAssocie);
        }
        return universiteRepository.save(universite);
    }

    @Override
    public Universite affecterFoyerToUniversite(Long idUniversite, Foyer foyer) {
        // Récupérer l'université par son ID
        Universite universiteExistante = universiteRepository.findById(idUniversite).orElse(null);

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
    public Universite DesaffecterFoyerFromUniversite(Long universiteId){
        Universite universite = universiteRepository.findById(universiteId).get();
        universite.setFoyer(null);
        universiteRepository.save(universite);
        return universite;
    }
}
