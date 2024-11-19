package com.example.foyer1.services;

import com.example.foyer1.entites.chambre;
import com.example.foyer1.entites.typeChambre;
import com.example.foyer1.repositories.ChambreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChambreService implements IChambreService
{ ChambreRepository chambreRepository;


    @Override
    public chambre addChambre(chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public chambre getChambreById(long idChambre) {
        return chambreRepository.findById(idChambre).get();
    }

    @Override
    public chambre updateChambre(chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void deleteChambre(chambre chambre) {
        chambreRepository.delete(chambre);
    }

    @Override
    public List<chambre> getAllChambre() {
        return chambreRepository.findAll();
    }



        public List<chambre> getChambreByType(typeChambre type) {
            return chambreRepository.findAllByTypeC(type);
        }
    @Override
    public chambre findByNumeroChambre(Long numeroChambre) {
        return chambreRepository.findChambreByNumeroChambre(numeroChambre);
    }
}
