package com.example.unidadeducativa.repositorios;

import com.example.unidadeducativa.entidades.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocenteRepository extends JpaRepository<Docente, Integer> {
}
