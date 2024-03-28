package com.example.Project.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="`VALIDATION`")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Validation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`IdValid`")
    private int IdValid;

    @Column(name = "`TypeValid`")
    private String TypeValid;

    @Column(name = "`DateValid`")
    private String DateValid;

    @Column(name = "`EtatValid`")
    private String EtatValid;

    @Column(name = "`IdVer`")
    private int IdVer;

    @JsonIgnore
    @ManyToMany(mappedBy = "validations")
    private List<Dev> devs;
}
