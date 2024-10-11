package com.casoPractico.dao;

import com.casoPractico.models.Persona;
import org.springframework.data.repository.CrudRepository;

public interface IPersonaDao extends CrudRepository<Persona, Long> {
}
