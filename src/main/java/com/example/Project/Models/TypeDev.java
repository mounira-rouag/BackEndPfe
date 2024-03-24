package com.example.Project.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="`TYPE_DEV`")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TypeDev {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`IdTypeDev`")

    private Integer IdTypeDev;

    @Column(name = "`NomTypeDev`")
    private String NomTypeDev;

    @Column(name = "`NumDico`")
    private Integer NumDico;

    @Column(name = "`Ordre`")
    private Integer Ordre;
}
