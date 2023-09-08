package com.institucional.WebIsp63.Controller;

import com.institucional.WebIsp63.DTO.MesaExamenDTO;
import com.institucional.WebIsp63.Service.MesaExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("MesaExamen")
public class MesaExamenController {
    @Autowired
    MesaExamenService mesaExamenService = new MesaExamenService();

    @GetMapping
    public List<MesaExamenDTO> finAll(){
        return mesaExamenService.findAll();
    }

    @PostMapping
    public MesaExamenDTO guardar(@RequestBody MesaExamenDTO mesaExamenDTO){
        return mesaExamenService.guardarMesa(mesaExamenDTO);
    }

    @GetMapping ("/{id}")
    public MesaExamenDTO finId(@PathVariable long id){
        return mesaExamenService.findId(id);
    }

    @PutMapping ("/mesaExamen/{id}")
    public MesaExamenDTO modificar(@PathVariable long id, @RequestBody MesaExamenDTO mesaExamenDTO){
        return  mesaExamenService.modifcarMesa(id,mesaExamenDTO);
    }

}
