package com.example.foyer1.repositories;

import com.example.foyer1.entites.foyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoyerRepository extends JpaRepository<foyer, Long> {
}
