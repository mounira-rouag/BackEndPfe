package com.example.Project.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="`FONCTION`")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Fonction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`IdFonction`")
    private int IdFonction;
    @Column(name = "`NomFonction`")
    private String NomFonction;
    @Column(name = "`Ordre`")
    private int Ordre;
    @Column(name = "`CodeDico`")
    private int CodeDico;
    @Column(name = "`DescrAnglais`")
    private String DescrAnglais;
    @JsonIgnore
    @ManyToMany(mappedBy = "fonctions")
    private List<CDC> cdc;

    @JsonIgnore
    @ManyToMany(mappedBy = "fonctions")
    private List<Dev> devs;
}