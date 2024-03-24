package com.example.Project.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="`Marque`")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`CODMAR`")
    private int idMarque;
    @Column(name = "`NOMMAR`")
    private String nomMarque;
   @JsonIgnore
    @OneToMany(mappedBy = "marque")
    private List<Vehicule> vehicules;


}
