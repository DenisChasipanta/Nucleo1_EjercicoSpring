package com.example.unidadeducativa.controladores;

import com.example.unidadeducativa.entidades.Curso;
import com.example.unidadeducativa.entidades.Estudiante;
import com.example.unidadeducativa.entidades.Matricula;
import com.example.unidadeducativa.repositorios.CursoRepository;
import com.example.unidadeducativa.repositorios.EstudianteRepository;
import com.example.unidadeducativa.repositorios.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class MatriculaControler {

    @Autowired
    MatriculaRepository matriculaRepository;
    @Autowired
    EstudianteRepository estudianteRepository;
    @Autowired
    CursoRepository cursoRepository;
    //READ
    @GetMapping("/matricula/formulario")
    public String formulario(Model model) {
        model.addAttribute("matricula", new Matricula());
        List<Estudiante> estudiantes= estudianteRepository.findAll();
        model.addAttribute("estudiantes", estudiantes);
        List<Curso> cursos= cursoRepository.findAll();
        model.addAttribute("cursos", cursos);
        return "matricula/formulario";
    }
    @GetMapping("/matriculas")
    public String matricula(Model model) {
        List<Matricula>matriculas= matriculaRepository.findAllWithCurso();
        model.addAttribute("matriculas", matriculas);
        List<Matricula>matriculas1= matriculaRepository.findAllWithEstudiante();
        model.addAttribute("matriculas1", matriculas1);
        return "matricula/matricula";
    }

    //CREATE
    @PostMapping("/matricula/formulario")
    public String crear(Matricula matricula){
        matriculaRepository.save(matricula);
        return "redirect:/matriculas";
    }

    //EDIT
    @GetMapping("/matricula/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<Matricula> matriculaOpt = matriculaRepository.findById(id);
        if (matriculaOpt.isPresent()) {
            Matricula matricula = matriculaOpt.get();
            model.addAttribute("matricula", matricula);

            List<Estudiante> estudiantes = estudianteRepository.findAll();
            model.addAttribute("estudiantes", estudiantes);

            List<Curso> cursos = cursoRepository.findAll();
            model.addAttribute("cursos", cursos);

            return "matricula/formulario";
        }
        return "redirect:/matriculas";
    }

    //DELETE
    @GetMapping("/matricula/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        matriculaRepository.deleteById(id);
        return "redirect:/matriculas";
    }
}
