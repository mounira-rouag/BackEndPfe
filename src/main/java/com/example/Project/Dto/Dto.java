package com.example.Project.Dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Dto {
    private String devname;
    private String dll;
    private boolean devDuplique;
    private String devComment;
    private String numBug;

    private Integer IdCDC;
    private Integer IdEcu;
    private Integer IdMaj;
    private Integer IdEtatDev;
    private Integer IdRC;
    private Integer IdMenu;
    private Integer IdTypeDev;


}
