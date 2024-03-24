package com.example.Project.Models;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IdVeh implements Serializable {

    private int codeVeh;


    private String nomVeh;


    private String nominterne;
}
