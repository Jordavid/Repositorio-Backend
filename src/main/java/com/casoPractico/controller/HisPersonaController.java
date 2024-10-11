package com.casoPractico.controller;

import com.casoPractico.models.HisPersona;
import com.casoPractico.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/hisPersona")
public class HisPersonaController {

    @Autowired
    IService<HisPersona> hisPersonaIService;

    @PostMapping
    public Map<String, String> guardar(@RequestBody HisPersona p){
        hisPersonaIService.guardar(p);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("msg", "His_Persona guardado correctamente");
        return respuesta;
    }

    @GetMapping
    public List<HisPersona> listar(){
        //Hago un peticion al servidor jorge
        return hisPersonaIService.listar();
    }


    @GetMapping("/obtener/{id}")
    public HisPersona obtenerPorId(@PathVariable(name = "id") Long id) {
        Optional<HisPersona> hisPersona = hisPersonaIService.getById(id);
        if (hisPersona.isPresent()) {
            return hisPersona.get();
        } else {
            return null;
        }
    }

    @DeleteMapping("/eliminar")
    public Map<String, String> eliminar(@RequestParam(name = "id") Long id){
        hisPersonaIService.eliminar(id);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("msg", "His_Persona eliminado correctamente");
        return respuesta;
    }

    @PutMapping("/actualizar/{id}")
    public Map<String, String> actualizar(@RequestBody HisPersona p,
                                          @PathVariable( name= "id") Long id){
        Optional<HisPersona> hisPersona = hisPersonaIService.getById(id);
        if (hisPersona.isPresent()) {
            p.setId(id);
            hisPersonaIService.guardar(p);
        } else {
            throw new RuntimeException("La His_Persona no esxiste en la bd");
        }
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("msg", "His_Persona actualizado correctamente");
        return respuesta;
    }
}
