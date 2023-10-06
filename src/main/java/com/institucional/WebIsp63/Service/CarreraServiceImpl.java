package com.institucional.WebIsp63.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.institucional.WebIsp63.DTO.CarreraDTO;
import com.institucional.WebIsp63.DTO.MensajeDTO;
import com.institucional.WebIsp63.Entity.Carrera;
import com.institucional.WebIsp63.Entity.Imagen;
import com.institucional.WebIsp63.Exception.ResourceNotFoundException;
import com.institucional.WebIsp63.Mapper.CarreraMapper;
import com.institucional.WebIsp63.Mapper.ImagenMapper;
import com.institucional.WebIsp63.Repository.CarreraRepository;
import com.institucional.WebIsp63.Repository.ImagenRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;


@Service
public class CarreraServiceImpl {
    @Autowired
    CarreraRepository carreraRepository;

    @Autowired
    CarreraMapper carreraMapper;
    @Autowired
    ImagenService imgService;



    @Transactional
    public CarreraDTO save(CarreraDTO carreraDTO, Imagen imagen) {
        Carrera carrera = new Carrera();
        carrera.setId(carreraDTO.getId());
        carrera.setNombre(carreraDTO.getNombre());
        carrera.setSede(carreraDTO.getSede());
        carrera.setHorario(carreraDTO.getHorario());
        carrera.setNumeroPlan(carreraDTO.getNumeroPlan());
        carrera.setCampoOcupacional(carreraDTO.getCampoOcupacional());
        carrera.setImagen(imagen);
        carreraRepository.save(carrera);
        return carreraDTO;
    }

    public boolean exists (long id){
        return carreraRepository.existsById(id);
    }

    public CarreraDTO JontoCarreraDTO( String carreraDTOJson)
    {
        CarreraDTO  carreraDTO;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            carreraDTO =  objectMapper.readValue(carreraDTOJson, CarreraDTO.class);
            return carreraDTO;
        } catch (Exception e) {
            e.printStackTrace();
            return null; //new ResponseEntity(new MensajeDTO("no se convirto a json" + carreraDTOJson ), HttpStatus.BAD_REQUEST);
        }

    }

    public List<CarreraDTO> findAll() throws ResourceNotFoundException{

        return  carreraMapper.toCarrerasDTO(carreraRepository.findAll());

    }
    public List<CarreraDTO> findAllBySede(String sede) throws ResourceNotFoundException{

        return  carreraMapper.toCarrerasDTO(carreraRepository.findBysedeContaining(sede));

    }





//probando consultas


    public CarreraDTO finId(long id) throws ResourceNotFoundException {

        Carrera carrera=carreraRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("carrera con id"+id+"no se encontro"));
        return carreraMapper.toCarreraDTO(carrera);
    }

    //agregar put, get por id, modificar
/*
    public CarreraDTO modificar(CarreraDTO carreraDTO) {
        Carrera objCarrera = new Carrera(carreraDTO.getId(), carreraDTO.getNombre(), carreraDTO.getSede(), carreraDTO.getNumeroPlan(), carreraDTO.getCampoOcupacional(), carreraDTO.getHorario(), ImagenMapper.Instance.toImagen( carreraDTO.getImagenDTO()));
        carreraRepository.save(objCarrera);
        return carreraDTO;
    }
*/
/*
    public CarreraDTO modificarCarrera(Long id, CarreraDTO carreraDTO) {
        Optional<Carrera> carreraOptional = carreraRepository.findById(id);

        if (carreraOptional.isEmpty()) {
            throw new RuntimeException("Id Invalido");
        }
        Carrera carrera = carreraOptional.get();
        carrera.setSede(carreraDTO.getSede());
        carrera.setHorario(carreraDTO.getHorario());
        carrera.setNombre(carreraDTO.getNombre());
        carrera.setNumeroPlan(carreraDTO.getNumeroPlan());
        carrera.setCampoOcupacional(carreraDTO.getCampoOcupacional());
        carrera.setImagen(ImagenMapper.Instance.toImagen( carreraDTO.getImagenDTO()));
        carreraRepository.save(carrera);

        return carreraDTO;
    }
*/
    public void Delete(long id) {
        carreraRepository.deleteById(id);
    }

}