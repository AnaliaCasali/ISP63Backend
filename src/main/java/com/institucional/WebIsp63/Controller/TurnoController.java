package com.institucional.WebIsp63.Controller;

import com.institucional.WebIsp63.DTO.TurnoDTO;
import com.institucional.WebIsp63.Exception.ResourceNotFoundException;
import com.institucional.WebIsp63.Service.TurnoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turno")
public class TurnoController {
    @Autowired
    TurnoServiceImpl turnoService;

    @GetMapping
    public List<TurnoDTO> findAll()  throws ResourceNotFoundException {
        return turnoService.findAll();
    }

    @GetMapping("/{id}")
    public TurnoDTO findId(@PathVariable long id)  throws ResourceNotFoundException {
        return turnoService.findId(id);
    }

    @PutMapping("/turno/{id}")
    public TurnoDTO modificar(@PathVariable long id, @RequestBody TurnoDTO turnoDTO){
        return turnoService.modificar(id, turnoDTO);
    }

    @PostMapping
    public TurnoDTO guardar(TurnoDTO turnoDTO){
        return  turnoService.guardarTurno(turnoDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        turnoService.deleteId(id);
    }


}
