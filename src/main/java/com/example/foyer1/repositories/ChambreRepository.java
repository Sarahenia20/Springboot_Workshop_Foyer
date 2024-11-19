package com.example.foyer1.Repositories;

import com.example.foyer1.Entities.Chambre;
import com.example.foyer1.Entities.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {

    List<Chambre> findAllByTypeC(TypeChambre tc);
    Chambre findChambreByNumeroChambre(Long numeroChambre);

}
