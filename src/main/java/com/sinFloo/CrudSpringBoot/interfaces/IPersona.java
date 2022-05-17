package com.sinFloo.CrudSpringBoot.interfaces;

import com.sinFloo.CrudSpringBoot.modelo.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersona extends CrudRepository<Persona,Integer> {
}
