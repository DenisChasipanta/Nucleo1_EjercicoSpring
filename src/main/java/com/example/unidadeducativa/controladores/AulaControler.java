package com.example.unidadeducativa.controladores;

import com.example.unidadeducativa.entidades.Aula;
import com.example.unidadeducativa.entidades.Curso;
import com.example.unidadeducativa.repositorios.AulaRepository;
import com.example.unidadeducativa.repositorios.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class AulaControler {
    @Autowired
    AulaRepository aulaRepository;

    @Autowired
    CursoRepository cursoRepository;

    //READ
    @GetMapping("/aula/formulario")
    public String formulario(Model model){
        model.addAttribute("aula", new Aula());
        List<Curso> cursos= cursoRepository.findAll();
        model.addAttribute("cursos", cursos);
        return "aula/formulario";
    }
    @GetMapping("/aulas")
    public String aula(Model model){
        List<Aula>aulas = aulaRepository.findAllWithCursos();
        model.addAttribute("aulas", aulas);
        return "aula/aula";
    }
    //CREATE
    @PostMapping("/aula/formulario")
    public String crearOActualizar(@ModelAttribute Aula aula) {
        if (aula.getId() != null) {
            // Es una actualización
            Aula aulaExistente = aulaRepository.findById(aula.getId()).orElse(null);
            if (aulaExistente != null) {
                aulaExistente.setAulaNumero(aula.getAulaNumero());
                aulaExistente.setAulaCapacidad(aula.getAulaCapacidad());
                aulaExistente.setCurso(aula.getCurso());
                aulaRepository.save(aulaExistente);
            }
        } else {
            // Es una nueva aula
            aulaRepository.save(aula);
        }
        return "redirect:/aulas";
    }

    //EDIT
    @GetMapping("/aula/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        Optional<Aula> aula = aulaRepository.findById(id);
        if(aula.isPresent()) {
            model.addAttribute("aula", aula.get());
            List<Curso> cursos = cursoRepository.findAll();
            model.addAttribute("cursos", cursos);
            return "aula/formulario";
        }
        return "redirect:/aulas";
    }

    //DELETE
    @GetMapping("/aula/eliminar/{id}")
    public String eliminar(@PathVariable int id){
        aulaRepository.deleteById(id);
        return "redirect:/aulas";
    }

}
