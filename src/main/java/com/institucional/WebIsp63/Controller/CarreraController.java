package com.institucional.WebIsp63.Controller;

import com.institucional.WebIsp63.DTO.CarreraDTO;

import com.institucional.WebIsp63.Exception.ResourceNotFoundException;

import com.institucional.WebIsp63.Service.CarreraService;
import com.institucional.WebIsp63.Service.CarreraServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrera")
public class CarreraController {

    @Autowired
    CarreraServiceImpl carreraService ;

    @GetMapping
    public List<CarreraDTO> finAll(String sede) throws ResourceNotFoundException {
        return carreraService.findAll(sede);
    }

    @PostMapping
    public CarreraDTO guardar(@RequestBody CarreraDTO carreraDTO) {
        return carreraService.GuardarCarrera(carreraDTO);
    }

    @GetMapping ("/{id}")
    public CarreraDTO findId(@PathVariable long id) throws ResourceNotFoundException {
        return carreraService.finId(id);
    }

    @PutMapping ("/carrera/{id}")
    public CarreraDTO modificar(@PathVariable Long id, @RequestBody CarreraDTO carreraDTO) {
        return carreraService.modificarCarrera(id, carreraDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        carreraService.Delete(id);
    }


}
