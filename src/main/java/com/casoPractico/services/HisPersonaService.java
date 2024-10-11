package com.casoPractico.services;

import com.casoPractico.dao.IHis_PersonaDao;
import com.casoPractico.models.HisPersona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HisPersonaService implements IService<HisPersona>{

    @Autowired
    private IHis_PersonaDao hisPersonaDao;

    @Override
    public List<HisPersona> listar() {
        List<HisPersona> hisPersona = new ArrayList<>();
        hisPersona = (List<HisPersona>) hisPersonaDao.findAll();
        return hisPersona;
    }

    @Override
    public Optional<HisPersona> getById(Long id) {
        Optional<HisPersona> hisPersona = hisPersonaDao.findById(id);
        return hisPersona;
    }

    @Override
    public void guardar(HisPersona hisPersona) {
        this.hisPersonaDao.save(hisPersona);
    }

    @Override
    public void eliminar(Long id) {
        this.hisPersonaDao.deleteById(id);
    }
}
