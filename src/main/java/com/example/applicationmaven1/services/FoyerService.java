package com.example.applicationmaven1.services;

import com.example.applicationmaven1.Entities.Bloc;
import com.example.applicationmaven1.Entities.Etudiant;
import com.example.applicationmaven1.Entities.Foyer;
import com.example.applicationmaven1.repositories.BlocRepository;
import com.example.applicationmaven1.repositories.FoyerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FoyerService implements IFoyerService {

    private final FoyerRepository foyerRepository;
    private final BlocRepository blocRepository;
    @Override
    public Foyer addFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }


    @Override
    public Foyer updateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }
    @Override
    public Foyer getFoyerById(long idFoyer) {
        return foyerRepository.findById((long) idFoyer).get();
    }
    @Override
    public void deleteFoyer(Foyer foyer) {
        foyerRepository.delete(foyer);
    }

    @Override
    public List<Foyer> getAllFoyer() {
        return foyerRepository.findAll();
    }

    // Method to assign an existing Bloc to an existing Foyer
    public void assignBlocToFoyer(Long idBloc, Long idFoyer) {
        Optional<Bloc> blocOpt = blocRepository.findById(idBloc);
        Optional<Foyer> foyerOpt = foyerRepository.findById(idFoyer);

        if (blocOpt.isPresent() && foyerOpt.isPresent()) {
            Bloc bloc = blocOpt.get();
            Foyer foyer = foyerOpt.get();

            // Assign the foyer to the bloc
            bloc.setFoyer(foyer);

            // Save the updated Bloc
            blocRepository.save(bloc);
        } else {
            throw new RuntimeException("Bloc or Foyer not found");
        }
    }
}
