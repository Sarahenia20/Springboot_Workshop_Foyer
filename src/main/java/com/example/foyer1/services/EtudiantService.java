package com.example.foyer1.services;

import com.example.foyer1.entites.etudiant;
import com.example.foyer1.repositories.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class EtudiantService implements IEtudiantService{
    EtudiantRepository etudiantRepository;


    @Override
    public etudiant addEtudiant(etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public etudiant getEtudiantById(long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).get();
    }

    @Override
    public etudiant updateEtudiant(etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void deleteEtudiant(etudiant etudiant) {
        etudiantRepository.delete(etudiant);
    }

    @Override
    public List<etudiant> getAllEtudiant() {
        return etudiantRepository.findAll();
    }
}
