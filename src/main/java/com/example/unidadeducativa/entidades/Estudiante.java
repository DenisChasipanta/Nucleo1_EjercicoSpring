package com.example.unidadeducativa.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String estudianteNombre;
    private String estudianteApellido;
    private LocalDate estudianteNacimiento;
    private String estudianteEmail;

}
