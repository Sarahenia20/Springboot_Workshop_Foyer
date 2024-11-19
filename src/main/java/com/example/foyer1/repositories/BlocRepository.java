package com.example.foyer1.repositories;

import com.example.foyer1.entites.bloc;
import com.example.foyer1.entites.chambre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlocRepository extends JpaRepository<bloc, Long> {

    List<bloc> findByFoyerUniversiteIdUniversite(Long idUniversite);
}
