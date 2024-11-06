package com.example.applicationmaven1.repositories;

import com.example.applicationmaven1.Entities.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoyerRepository extends JpaRepository<Foyer, Integer> {

}
