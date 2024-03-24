package com.example.Project.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity


@Table(name="`Vehid`")
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`CODE_VEH`")
    private int codeVeh;


    @Column(name = "`NOMVEH`")
    private String nomVeh;


    @Column(name = "`NOMINTERNE`")
    private String nominterne;



    @Column(name = "`TESTGLOBAL`")
    private boolean testGlobal;
    @Column(name = "`MSG_DIAG`")
    private String msgDiag;
    @Column(name = "`GRPMARQ`")
    private String grpMarque;
    @Column(name = "`FROM`")
    private String from;
    @Column(name = "`TO`")
    private String to;
    @Column(name = "`OnlyElec`")

    private boolean onlyElec;
    @Column(name = "`AVERTISS_ELEC`")
    private boolean avertissElec;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "`IdMarque`")
    private Marque marque;
     @JsonIgnore
    @ManyToMany(mappedBy = "vehicules")
    private List<Dev> devs;

}
