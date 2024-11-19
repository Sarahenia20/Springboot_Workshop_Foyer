package com.example.foyer1.services;


import com.example.foyer1.entites.etudiant;

import java.util.List;

public interface IEtudiantService {
    etudiant addEtudiant(etudiant etudiant);

    etudiant getEtudiantById(long idEtudiant);

    etudiant updateEtudiant(etudiant etudiant);

    void deleteEtudiant(etudiant etudiant);

    List<etudiant> getAllEtudiant();
}
