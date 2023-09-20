package com.institucional.WebIsp63.Controller;

import com.institucional.WebIsp63.DTO.MesaExamenDTO;
import com.institucional.WebIsp63.Exception.ResourceNotFoundException;
import com.institucional.WebIsp63.Service.MesaExamenService;
import com.institucional.WebIsp63.Service.MesaExamenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesaExamen")
public class MesaExamenController {
    @Autowired
    MesaExamenServiceImpl mesaExamenService= new MesaExamenServiceImpl() ;

    @GetMapping
    public List<MesaExamenDTO> finAll() throws ResourceNotFoundException {
        return mesaExamenService.findAll();   }

    @PostMapping
    public MesaExamenDTO guardar(@RequestBody MesaExamenDTO mesaExamenDTO){
        return mesaExamenService.guardarMesa(mesaExamenDTO);
    }

    @GetMapping ("/{id}")
    public MesaExamenDTO finId (@PathVariable long id) throws ResourceNotFoundException{
        return mesaExamenService.findId(id);
    }

    @PutMapping ("/mesaExamen/{id}")
    public MesaExamenDTO modificar(@PathVariable long id, @RequestBody MesaExamenDTO mesaExamenDTO){
        return  mesaExamenService.modifcarMesa(id,mesaExamenDTO);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        mesaExamenService.delete(id);
    }

}
