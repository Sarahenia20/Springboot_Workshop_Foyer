package com.example.foyer1.services;


import com.example.foyer1.entites.chambre;
import com.example.foyer1.entites.typeChambre;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;



public interface IChambreService {
    chambre addChambre(chambre chambre);

    chambre getChambreById(long idChambre);

    chambre updateChambre(chambre chambre);

    void deleteChambre(chambre chambre);

    List<chambre> getAllChambre();
    List<chambre> getChambreByType( typeChambre type);
    public chambre findByNumeroChambre(Long numeroChambre);
}
