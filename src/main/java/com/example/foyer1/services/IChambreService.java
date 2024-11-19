package com.example.foyer1.Services;


import com.example.foyer1.Entities.Chambre;
import com.example.foyer1.Entities.TypeChambre;

import java.util.List;



public interface IChambreService {
    Chambre addChambre(Chambre chambre);

    Chambre getChambreById(long idChambre);

    Chambre updateChambre(Chambre chambre);

    void deleteChambre(Chambre chambre);

    List<Chambre> getAllChambre();
    List<Chambre> getChambreByType( TypeChambre type);
    public Chambre findByNumeroChambre(Long numeroChambre);
}
