package com.example.foyer1.entites;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class bloc implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idBloc;
    private String numBloc;
    private long capaciteBloc;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "bloc")
    private Set<chambre> chambres;
    @ManyToOne
    @JsonIgnore
    private foyer foyer;

}
