package com.example.unidadeducativa.repositorios;

import com.example.unidadeducativa.entidades.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer>{
    @Query("SELECT a FROM Matricula a LEFT JOIN FETCH a.curso")
    List<Matricula> findAllWithCurso();
    @Query("SELECT a FROM Matricula a LEFT JOIN FETCH a.estudiante")
    List<Matricula> findAllWithEstudiante();


}
