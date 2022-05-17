package com.sinFloo.CrudSpringBoot.interfazServicio;

import com.sinFloo.CrudSpringBoot.modelo.Persona;

import java.util.List;
import java.util.Optional;

public interface IpersonaServicio {

    public List<Persona>listar();
    public Optional<Persona>listarId(int id);
    public int save(Persona p);
    public void delete(int id);

}
