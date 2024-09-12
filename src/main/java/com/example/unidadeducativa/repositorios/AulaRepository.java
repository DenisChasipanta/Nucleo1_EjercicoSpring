package com.example.unidadeducativa.repositorios;

import com.example.unidadeducativa.entidades.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AulaRepository extends JpaRepository<Aula, Integer> {
    @Query("SELECT a FROM Aula a LEFT JOIN FETCH a.curso")
    List<Aula> findAllWithCursos();
}
