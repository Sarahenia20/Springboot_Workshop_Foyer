package com.example.foyer1.Repositories;

import com.example.foyer1.Entities.Bloc;
import com.example.foyer1.Entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlocRepository extends JpaRepository<Bloc, Long> {

    List<Bloc> findByFoyerUniversiteIdUniversite(Long idUniversite);
}
