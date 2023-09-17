package com.institucional.WebIsp63.Controller;

import com.institucional.WebIsp63.DTO.InscripcionDTO;
import com.institucional.WebIsp63.Exception.ResourceNotFoundException;
import com.institucional.WebIsp63.Service.InscripcionService;

import com.institucional.WebIsp63.Service.InscripcionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscripcion")
public class InscripcionController {
    @Autowired
    InscripcionServiceImpl inscripcionService;

    @PostMapping
    public InscripcionDTO guardar( @RequestBody InscripcionDTO inscripcionDTO){
        return inscripcionService.guardarInscripcion(inscripcionDTO);
    }
    @GetMapping
    public List<InscripcionDTO> findAll() throws ResourceNotFoundException{
        return inscripcionService.findAll();
    }
    @GetMapping ("/{id}")
    public InscripcionDTO findId(@PathVariable long id) throws ResourceNotFoundException {
        return inscripcionService.findId(id);
    }

    @PutMapping("/inscripcion/{id}")
    public InscripcionDTO modificar(@PathVariable long id, @RequestBody InscripcionDTO inscripcionDTO){
        return inscripcionService.modificar(id,inscripcionDTO);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        inscripcionService.delete(id);
    }
}
