package com.casoPractico.services;

import com.casoPractico.dao.IPersonaDao;
import com.casoPractico.models.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements IService<Persona>{

    @Autowired
    private IPersonaDao personaDao;
    @Override
    public List<Persona> listar() {
        List<Persona> persona = new ArrayList<>();
        persona = (List<Persona>) personaDao.findAll();
        return persona;
    }

    @Override
    public Optional<Persona> getById(Long id) {
        Optional<Persona> persona = personaDao.findById(id);
        return persona;
    }

    @Override
    public void guardar(Persona persona) {
        this.personaDao.save(persona);
    }

    @Override
    public void eliminar(Long id) {
        this.personaDao.deleteById(id);
    }
}
