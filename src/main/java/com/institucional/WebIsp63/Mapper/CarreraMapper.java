package com.institucional.WebIsp63.Mapper;

import com.institucional.WebIsp63.DTO.CarreraDTO;
import com.institucional.WebIsp63.Entity.Carrera;
import com.institucional.WebIsp63.Repository.CarreraRepository;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ImagenMapper.class})
public interface CarreraMapper {
    static final CarreraMapper Instance=Mappers.getMapper(CarreraMapper.class);
    CarreraDTO toCarreraDTO(Carrera carrera);

    Carrera toCarrera(CarreraDTO DTO);
    List<CarreraDTO> toCarrerasDTO(List<Carrera> carreras);

    List<Carrera> toCarreras(List<CarreraDTO> CarrerasDTO);

}
