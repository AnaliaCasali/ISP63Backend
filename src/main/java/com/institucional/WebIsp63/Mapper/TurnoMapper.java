package com.institucional.WebIsp63.Mapper;

import com.institucional.WebIsp63.DTO.TurnoDTO;
import com.institucional.WebIsp63.Entity.Turno;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TurnoMapper {
    TurnoMapper Instance= Mappers.getMapper(TurnoMapper.class);

    TurnoDTO toTurnoDTO(Turno turno);
    Turno toTurno(TurnoDTO turnoDTO);

    List<TurnoDTO> toTurnosDTO(List<Turno> turnos);

    List<TurnoDTO>toTurnos(List<TurnoDTO> turnoDTOS);
}
