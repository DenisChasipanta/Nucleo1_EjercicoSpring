package com.example.unidadeducativa.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int aulaNumero;
    private int aulaCapacidad;

    @OneToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
}
