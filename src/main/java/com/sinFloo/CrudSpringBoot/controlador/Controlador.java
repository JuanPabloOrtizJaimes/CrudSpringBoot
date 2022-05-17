package com.sinFloo.CrudSpringBoot.controlador;

import com.sinFloo.CrudSpringBoot.interfazServicio.IpersonaServicio;
import com.sinFloo.CrudSpringBoot.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private IpersonaServicio servicio;

    @GetMapping("/listar")
    public String listar(Model model){
        List<Persona> personas=servicio.listar();
        model.addAttribute("personas",personas);
        return "indice";
    }
    
    @GetMapping("/new")
    public String agregar(Model model){
        model.addAttribute("persona",new Persona());
        return "formulario";
    }
    
    @PostMapping("/save")
    public String save(@Valid Persona p, Model model){
        servicio.save(p);
        return "redirect:/listar";
    }
    
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        Optional<Persona>persona=servicio.listarId(id);
        model.addAttribute("persona",persona);
        return "formulario";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id, Model model){
        servicio.delete(id);
        return "redirect:/listar";
    }
}
