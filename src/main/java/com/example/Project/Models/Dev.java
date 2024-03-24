package com.example.Project.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "`DEV`")
public class Dev {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`IdDev`")
    private int id;
    @Column(name = "`NomDev`")
    private String devname;
    @Column(name = "`NomDLL`")
    private String dll;
    @Column(name = "`DevDuplique`")
    private boolean devDuplique;
    @Column(name = "`DevComment`")
    private String devComment;
    @Column(name = "`NumBugzilla`")
    private String numBug;


    @ManyToOne
    @JoinColumn(name = "`IdCDC`")
    private CDC cdc;


    @ManyToOne
    @JoinColumn(name = "`IdEcu`")
    private Ecu ecu;
   @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "`IdMaj`")
    private Maj maj;

    @ManyToOne
    @JoinColumn(name = "`IdEtatDev`")
    private EtatDev etatdev;

    @ManyToOne
    @JoinColumn(name = "`IdMenu`")
    private Menu menu;


    @ManyToOne
    @JoinColumn(name = "`IdRC`")
    private User user;
@JsonIgnore
    @ManyToMany
    @JoinTable(  name = "`VEH_BY_DEV`",
            joinColumns = @JoinColumn(name = "`IdDev`"),
            inverseJoinColumns ={ @JoinColumn(name = "`GRPMOD`"),

                                }
    )
    private List<Vehicule> vehicules;


}
