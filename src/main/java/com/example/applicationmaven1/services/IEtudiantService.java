package com.example.applicationmaven1.services;


import com.example.applicationmaven1.Entities.Etudiant;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("etudiantServiceImpl")
public interface IEtudiantService {
    Etudiant addEtudiant(Etudiant etudiant);

    Etudiant getEtudiantById(long idEtudiant);

    Etudiant updateEtudiant(Etudiant etudiant);

    void deleteEtudiant(Etudiant etudiant);

    List<Etudiant> getAllEtudiant();
}
