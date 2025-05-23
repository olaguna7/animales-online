package com.oscar.mascotasonline.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MascotaDTO {
    private int id;
    private String nombre;
    private Date fechaNacimiento;
    private String raza;
    private double peso;
    private boolean tieneChip;
    private String urlFoto;
    private PropietarioDTO propietario;
}
