package com.example.foyer1.repositories;

import com.example.foyer1.entites.etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<etudiant, Long> {
}
