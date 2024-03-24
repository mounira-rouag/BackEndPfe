package com.example.Project.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name="`MENU`")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`IdMenu`")
    private Integer idMenu;
    @Column(name = "`PathMenu`")
    private String PathMenu;
    @Column(name = "`DateDemandeXLS`")
    private Timestamp DateDemandeXLS;
    @Column(name = "`HeureDemandeXLS`")
    private Timestamp HeureDemandeXLS;
    @Column(name = "`LectDef`")
    private boolean LectDef;
    @Column(name = "`EffDef`")
    private boolean EffDef;
    @Column(name = "`Genere`")
    private boolean Genere;
    @Column(name = "`MessageInit`")
    private boolean MessageInit;
    @Column(name = "`CodeMessageInit`")
    private String CodeMessageInit;
    @Column(name = "`MessagePrinc`")
    private boolean MessagePrinc;
    @Column(name = "`CodeMessagePrinc`")
    private String CodeMessagePrinc;
    @Column(name = "`NoDtcNegFilter`")
    private boolean NoDtcNegFilter;

}
