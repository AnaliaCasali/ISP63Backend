package com.institucional.WebIsp63.Service;

import com.institucional.WebIsp63.DTO.CarreraDTO;
import com.institucional.WebIsp63.Entity.Carrera;
import com.institucional.WebIsp63.Repository.CarreraRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarreraService {
    @Autowired
    CarreraRepository carreraRepository;

    @Transactional
    public CarreraDTO GuardarCarrera(CarreraDTO carreraDTO) {
        Carrera carrera = new Carrera();

        carrera.setId(carreraDTO.getId());
        carrera.setNombre(carreraDTO.getNombre());
        carrera.setSede(carreraDTO.getSede());
        carrera.setHorario(carreraDTO.getHorario());
        carrera.setNumeroPlan(carreraDTO.getNumeroPlan());
        carrera.setCampoOcupacional(carreraDTO.getCampoOcupacional());
        carreraRepository.save(carrera);
        return carreraDTO;
    }


    public List<CarreraDTO> findAll() {
        return carreraRepository.findAll()
                .stream().map(carrera -> new CarreraDTO(carrera.getId(), carrera.getNombre(), carrera.getSede(), carrera.getNumeroPlan(), carrera.getCampoOcupacional(), carrera.getHorario()))
                .collect(Collectors.toList());
    }


    public CarreraDTO finId(long id) {
        Optional<Carrera> carreraOptional = carreraRepository.findById(id);
        if (carreraOptional.isEmpty()) {
            throw new RuntimeException("Id Invalido");
        }
        Carrera carrera = carreraOptional.get();
        return new CarreraDTO(carrera.getId(), carrera.getNombre(), carrera.getSede(), carrera.getNumeroPlan(), carrera.getCampoOcupacional(), carrera.getHorario());

    }

    //agregar put, get por id, modificar

    public CarreraDTO modificar(CarreraDTO carreraDTO) {
        Carrera objCarrera = new Carrera(carreraDTO.getId(), carreraDTO.getNombre(), carreraDTO.getSede(), carreraDTO.getNumeroPlan(), carreraDTO.getCampoOcupacional(), carreraDTO.getHorario());
        carreraRepository.save(objCarrera);
        return carreraDTO;
    }


    public CarreraDTO modificarCarrera( Long id, CarreraDTO carreraDTO) {
        Optional<Carrera> carreraOptional = carreraRepository.findById(id);

        if (carreraOptional.isEmpty()) {
            throw new RuntimeException("Id Invalido");
        }
        Carrera carrera =carreraOptional.get();
        carrera.setSede(carreraDTO.getSede());
        carrera.setHorario(carreraDTO.getHorario());
        carrera.setNombre(carreraDTO.getNombre());
        carrera.setNumeroPlan(carreraDTO.getNumeroPlan());
        carrera.setCampoOcupacional(carreraDTO.getCampoOcupacional());
        carreraRepository.save(carrera);

        return carreraDTO;
    }

    public void Delete(long id) {
        carreraRepository.deleteById(id);
    }

}