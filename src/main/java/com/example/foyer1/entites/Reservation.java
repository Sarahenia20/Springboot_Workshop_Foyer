package com.example.foyer1.entites;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idReservation;
    private Date anneeUniversitaire;
    private boolean estValide;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<etudiant> etudiants;
}
