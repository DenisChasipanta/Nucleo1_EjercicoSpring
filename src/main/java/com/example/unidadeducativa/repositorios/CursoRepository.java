package com.example.unidadeducativa.repositorios;

import com.example.unidadeducativa.entidades.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso,Integer> {
}
