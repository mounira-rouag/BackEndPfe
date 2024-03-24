package com.example.Project.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="`FAMILLE`")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Famille {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`IdFamille`")
    private int idFamille;
    @Column(name = "`Nomfamille`")
    private String nomfamille;
    @Column(name = "`Description`")
    private String description;
    @Column(name = "`Phrase`")
    private String phrase;
    @Column(name = "`DescrAnglais`")
    private String descrAnglais;
    @Column(name = "`Ordre`")
    private short ordre;
    @Column(name = "`GuidedMethFilter`")
    private boolean guidedMethFilter;
    @Column(name = "`SparePartsFilter`")
    private boolean sparePartsFilter;

    @JsonIgnore
    @OneToMany(mappedBy = "famille")
    private List<Ecu> ecu;

}
