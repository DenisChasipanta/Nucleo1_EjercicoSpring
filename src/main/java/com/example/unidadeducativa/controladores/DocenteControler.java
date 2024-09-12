package com.example.unidadeducativa.controladores;

import com.example.unidadeducativa.entidades.Docente;
import com.example.unidadeducativa.repositorios.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class DocenteControler {
    @Autowired
    DocenteRepository docenteRepository;

    //READ
    @GetMapping("/docente/formulario")
    public String formulario(Model model) {
        model.addAttribute("docente", new Docente());
        return "docente/formulario";
    }

    @GetMapping("/docentes")
    public String docente(Model model) {
        List<Docente>docentes = docenteRepository.findAll();
        model.addAttribute("docentes", docentes);
        return "docente/docente";
    }

    //CREATE
    @PostMapping("/docente/formulario")
    public  String crear(Docente docente) {
        docenteRepository.save(docente);
        return "redirect:/docentes";
    }

    //EDIT
    @GetMapping("/docente/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<Docente>docente = docenteRepository.findById(id);
        model.addAttribute("docente",docente);
        return "docente/formulario";
    }

    //DELETE
    @GetMapping("/docente/eliminar/{id}")
    public String eliminar(@PathVariable int id){
        docenteRepository.deleteById(id);
        return "redirect:/docentes";
    }
}
