package com.example.Project.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="`REVERSE`")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reverse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`IdReverse`")
    private Integer idReverse;

    @Column(name = "`NomReverse`")
    private String nomReverse;

    @Column(name = "`NumDico`")
    private Integer numDico;

    @Column(name = "`PROFIL`")
    private String profil;

    @Column(name = "`GEO`")
    private String geo;
    @JsonIgnore
    @OneToMany(mappedBy = "reverse")
    private List<CDC> cdc;
}
