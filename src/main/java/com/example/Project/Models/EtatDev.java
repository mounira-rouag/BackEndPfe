package com.example.Project.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="`ETAT_DEV`")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EtatDev {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`IdEtatDev`")
    private int IdEtatDev;
    @Column(name = "`NomEtatDev`")
    private String NomEtatDev;

    @JsonIgnore
    @OneToMany(mappedBy = "etatdev")
    private List<Dev> dev;
}
