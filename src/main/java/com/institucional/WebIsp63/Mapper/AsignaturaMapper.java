package com.institucional.WebIsp63.Mapper;

import com.institucional.WebIsp63.DTO.AsignaturaDTO;
import com.institucional.WebIsp63.Entity.Asignatura;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.ListResourceBundle;

@Mapper(componentModel = "spring")
public interface AsignaturaMapper {

    AsignaturaMapper Instance = Mappers.getMapper(AsignaturaMapper.class);

    AsignaturaDTO ToasignaturaDTO(Asignatura asignatura);
    Asignatura toAsignatura (AsignaturaDTO asignaturaDTO);

    List<AsignaturaDTO>toAsignaturasDTO(List<Asignatura> asignaturas);
    List<AsignaturaDTO>toAsignatura(List<AsignaturaDTO> asignaturaDTOS);



}
