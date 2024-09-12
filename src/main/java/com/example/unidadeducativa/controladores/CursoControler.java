package com.example.unidadeducativa.controladores;

import com.example.unidadeducativa.entidades.Curso;
import com.example.unidadeducativa.repositorios.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class CursoControler {
    @Autowired
    CursoRepository cursoRepository;

    //READ
    @GetMapping("/curso/formulario")
    public String formulario(Model model) {
        model.addAttribute("curso", new Curso());
        return "curso/formulario";
    }

    @GetMapping("/cursos")
    public String cursos(Model model) {
        List<Curso>cursos=cursoRepository.findAll();
        model.addAttribute("cursos", cursos);
        return "curso/curso";
    }
    //CREATE
    @PostMapping("/curso/formulario")
    public String crear(Curso curso) {
        cursoRepository.save(curso);
        return "redirect:/cursos";
    }
    //EDIT
    @GetMapping("/curso/editar/{id}")
    public String editar(@PathVariable("id") Integer id, Model model) {
        Optional<Curso>curso=cursoRepository.findById(id);
        model.addAttribute("curso",curso);
        return "curso/formulario";
    }

    //DELETE
    @GetMapping("/curso/eliminar/{id}")
    public String eliminar(@PathVariable int id){
        cursoRepository.deleteById(id);
        return "redirect:/cursos";
    }
}
