package com.oscar.mascotasonline.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "MASCOTA")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    @Column(name = "fechaNacimiento")
    private Date fechaNacimiento;
    @Enumerated(EnumType.STRING)
    private Raza raza;
    private double peso;
    private boolean tieneChip;
    private String urlFoto;

    @ManyToOne
    @JoinColumn(name = "id_propietario")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = false)
    private Propietario propietario;
}
