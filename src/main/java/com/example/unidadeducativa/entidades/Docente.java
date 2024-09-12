package com.example.unidadeducativa.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String profesorNombre;
    private String profesorApellido;
    private String profesorEmail;
    private String profesorEspecialidad;
}
