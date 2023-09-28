package com.institucional.WebIsp63.Controller;

import com.institucional.WebIsp63.DTO.CarreraDTO;

import com.institucional.WebIsp63.Exception.ResourceNotFoundException;

import com.institucional.WebIsp63.Service.CarreraService;
import com.institucional.WebIsp63.Service.CarreraServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrera")
//@CrossOrigin(origins = "https://localhost:4200/carrera")

public class CarreraController {

    @Autowired
    CarreraServiceImpl carreraService ;

    @GetMapping
    public ResponseEntity<List<CarreraDTO>>  finAll() throws ResourceNotFoundException {
        //return carreraService.findAll();
        List<CarreraDTO> list = carreraService.findAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/sede/{sede}")
    public List<CarreraDTO> finAllBySede(@PathVariable String sede) throws ResourceNotFoundException {
        return carreraService.findAllBySede(sede);
    }


    @PostMapping("/create")
    public CarreraDTO guardar(@RequestBody CarreraDTO carreraDTO) {
        return carreraService.GuardarCarrera(carreraDTO);
    }

    @GetMapping ("/detail/{id}")
    public CarreraDTO findId(@PathVariable long id) throws ResourceNotFoundException {
        return carreraService.finId(id);
    }

    @PutMapping ("/update/{id}")
    public CarreraDTO modificar(@PathVariable Long id, @RequestBody CarreraDTO carreraDTO) {
        return carreraService.modificarCarrera(id, carreraDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        carreraService.Delete(id);
    }


}
