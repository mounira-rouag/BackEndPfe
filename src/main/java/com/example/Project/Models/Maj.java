package com.example.Project.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="`MAJ`")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Maj {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`IdMaj`")
    private int idMaj;

    @Column(name = "`NomMaj`", length = 50)
    private String nomMaj;

    @Column(name = "`TypeMaj`", length = 50)
    private String typeMaj;

    @Column(name = "`StatusMaj`", length = 50)
    private String statusMaj;

    @Column(name = "`Ordre`")
    private Short ordre;

    @Column(name = "`EnCours`")
    private Boolean enCours;

    @Column(name = "`AtalMaj`", length = 10)
    private String atalMaj;

    @Column(name = "`NomMajOffice`", length = 50)
    private String nomMajOffice;

    @JsonIgnore
    @OneToMany(mappedBy = "maj")
    private List<Dev> dev;
}
