package com.casoPractico.controller;

import com.casoPractico.models.Persona;
import com.casoPractico.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/persona")
@CrossOrigin("*")
public class PersonaController {

    @Autowired
    IService<Persona> personaService;

    @PostMapping
    public Map<String, Object> guardar(@RequestBody Persona p){
        personaService.guardar(p);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("id: ", p.getId());
        respuesta.put("msg", "Persona guardado correctamente");
        return respuesta;
    }

    @GetMapping
    public List<Persona> listar(){
        //Hago un peticion al servidor jorge
        return personaService.listar();
    }


    @GetMapping("/obtener/{id}")
    public Persona obtenerPorId(@PathVariable(name = "id") Long id) {
        Optional<Persona> persona = personaService.getById(id);
        if (persona.isPresent()) {
            return persona.get();
        } else {
            return null;
        }
    }

    @DeleteMapping("/eliminar")
    public Map<String, String> eliminar(@RequestParam(name = "id") Long id){
        personaService.eliminar(id);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("msg", "Persona eliminado correctamente");
        return respuesta;
    }

    @PutMapping("/actualizar/{id}")
    public Map<String, Object> actualizar(@RequestBody Persona p,
                                          @PathVariable( name= "id") Long id){
        Optional<Persona> persona = personaService.getById(id);
        if (persona.isPresent()) {
            p.setId(id);
            personaService.guardar(p);
        } else {
            throw new RuntimeException("La Persona no esxiste en la bd");
        }
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("id", p.getId());
        respuesta.put("msg", "Persona actualizado correctamente");
        return respuesta;
    }
}
