package com.example.foyer1.repositories;

import com.example.foyer1.entites.chambre;
import com.example.foyer1.entites.typeChambre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChambreRepository extends JpaRepository<chambre, Long> {

    List<chambre> findAllByTypeC(typeChambre tc);
    chambre findChambreByNumeroChambre(Long numeroChambre);
}
