package com.example.Project.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "`CDC`")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CDC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`IdCDC`")
    private int idCdc;

    @Column(name = "`NomCDC`", length = 100)
    private String nomCdc;

    @Column(name = "`RefCDC`", length = 50)
    private String refCdc;

    @Column(name = "`IndCDC`", length = 50)
    private String indCdc;

    @Column(name = "`Création`")
    private Timestamp creation;

    @Column(name = "`SignatureOk`", nullable = false)
    private boolean signatureOk;

    @Column(name = "`RefCDCArdia`", length = 10)
    private String refCdcArdia;

    @JsonIgnore
    @OneToMany(mappedBy = "cdc")
    private List<Dev> dev;


    @ManyToOne
    @JoinColumn(name = "`IdReverse`")
    private Reverse reverse;
@JsonIgnore
    @ManyToMany
    @JoinTable(  name = "`FCT_BY_CDC`",
            joinColumns = @JoinColumn(name = "`IdCDC`"),
            inverseJoinColumns ={ @JoinColumn(name = "`IdFonction`"),

            }
    )
    private List<Fonction> fonctions;
}
