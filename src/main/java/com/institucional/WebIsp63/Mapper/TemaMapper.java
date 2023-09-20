package com.institucional.WebIsp63.Mapper;


import com.institucional.WebIsp63.DTO.TemaDTO;

import com.institucional.WebIsp63.Entity.Tema;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TemaMapper {
    TemaMapper INSTANCE= Mappers.getMapper(TemaMapper.class);
    TemaDTO toTemaDTO(Tema tema);

    Tema toTema (TemaDTO DTO);
    List<TemaDTO> totemasDTO(List<Tema> temas);
    List<Tema>toTemas(List<TemaDTO> temaDTOS);
}
