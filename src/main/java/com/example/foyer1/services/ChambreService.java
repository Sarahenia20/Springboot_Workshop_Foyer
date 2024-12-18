package com.example.foyer1.Services;

import com.example.foyer1.Entities.Chambre;
import com.example.foyer1.Entities.TypeChambre;
import com.example.foyer1.Repositories.ChambreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChambreService implements IChambreService
{ ChambreRepository chambreRepository;


    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre getChambreById(long idChambre) {
        return chambreRepository.findById(idChambre).get();
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void deleteChambre(Chambre chambre) {
        chambreRepository.delete(chambre);
    }

    @Override
    public List<Chambre> getAllChambre() {
        return chambreRepository.findAll();
    }



        public List<Chambre> getChambreByType(TypeChambre type) {
            return chambreRepository.findAllByTypeC(type);
        }
    @Override
    public Chambre findByNumeroChambre(Long numeroChambre) {
        return chambreRepository.findChambreByNumeroChambre(numeroChambre);
    }
}
