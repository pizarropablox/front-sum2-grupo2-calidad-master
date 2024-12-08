package com.example.recetas_front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RouterController {

    @GetMapping("/registro")
    public String mostrarFormularioRegistro() {
        return "registro";
    }

    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "login";
    }

    @GetMapping("/inicio")
    public String mostrarInicio() {
        return "inicio";
    }

    @GetMapping("/")
    public String mostrarIndex() {
        return "redirect:/inicio";
    }

    @GetMapping("/receta/{id}")
    public String verReceta(@PathVariable Long id) {
        return "receta";
    }

    @GetMapping("/buscar")
    public String mostrarBusqueda() {
        return "busqueda";
    }

    @GetMapping("/publicar")
    public String publicar() {
        return "publicar";
    }

    @GetMapping("/403")
    public String noAutorizado() {
        return "403";
    }

    @GetMapping("/admin")
    public String adminPanel() {
        return "administracion";
    }
}
