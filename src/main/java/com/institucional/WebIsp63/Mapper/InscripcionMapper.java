package com.institucional.WebIsp63.Mapper;

import com.institucional.WebIsp63.DTO.InscripcionDTO;
import com.institucional.WebIsp63.Entity.Inscripcion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InscripcionMapper {
    InscripcionMapper Instance= Mappers.getMapper(InscripcionMapper.class);

    InscripcionDTO toInscripcionDTO(Inscripcion inscripcion);
    Inscripcion toInscripcion(InscripcionDTO inscripcionDTO);

    List<InscripcionDTO>toInscripcionesDTO(List<Inscripcion> inscripciones);
    List<InscripcionDTO> toInscripciones(List<InscripcionDTO> inscripcionDTOS);
}
