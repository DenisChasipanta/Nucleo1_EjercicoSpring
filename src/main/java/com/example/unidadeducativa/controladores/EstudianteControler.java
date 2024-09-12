package com.example.unidadeducativa.controladores;

import com.example.unidadeducativa.entidades.Estudiante;
import com.example.unidadeducativa.repositorios.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class EstudianteControler {
    @Autowired
    EstudianteRepository estudianteRepository;

    //REED
    @GetMapping("/estudiante/formulario")
    public String formulario(Model model){
        model.addAttribute("estudiante", new Estudiante());
        return "estudiante/formulario";
    }

    @GetMapping("/estudiantes")
    public String estudiante(Model model){
        List<Estudiante> estudiantes = estudianteRepository.findAll();//Traer todos los elemetos del Repositorio de empleados
        model.addAttribute("estudiantes", estudiantes);
        return "estudiante/estudiante";
    }

    //CREATE
    @PostMapping("/estudiante/formulario")
    public String crear(Estudiante estudiante) {
        estudianteRepository.save(estudiante);//Guarda un estudiante
        return "redirect:/estudiantes";
    }


    //EDIT
    @GetMapping("/estudiante/editar/{id}")
    public String editar(@PathVariable int id,Model model){
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de estudiante inválido:" + id));
        model.addAttribute("estudiante", estudiante);
        return "estudiante/formulario";
    }

    //DELETE
    @GetMapping("/estudiante/eliminar/{id}")
    public String eliminar(@PathVariable int id){
        estudianteRepository.deleteById(id);
        return "redirect:/estudiantes";
    }


}
