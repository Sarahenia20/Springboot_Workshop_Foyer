package com.example.foyer1.services;



import com.example.foyer1.entites.bloc;
import com.example.foyer1.entites.foyer;
import com.example.foyer1.repositories.BlocRepository;
import com.example.foyer1.repositories.FoyerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerService implements IFoyerService{
    FoyerRepository foyerRepository;
    BlocRepository blocRepository;


    @Override
    public foyer addFoyer(foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public foyer getFoyerById(long idFoyer) {
        return foyerRepository.findById(idFoyer).get();
    }

    @Override
    public foyer updateFoyer(foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public void deleteFoyer(foyer foyer) {
        foyerRepository.delete(foyer);
    }

    @Override
    public List<foyer> getAllFoyer() {
        return foyerRepository.findAll();
    }
    @Override
    public void assignBlocToFoyer(Long idBloc, Long idFoyer) {
        bloc bloc = blocRepository.findById(idBloc).get();
        foyer foyer = foyerRepository.findById(idFoyer).get();
        bloc.setFoyer(foyer);
        blocRepository.save(bloc);
    }
}




