package com.example.unidadeducativa.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaControler {
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
