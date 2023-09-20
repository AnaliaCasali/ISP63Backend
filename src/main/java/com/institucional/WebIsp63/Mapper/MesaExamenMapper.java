package com.institucional.WebIsp63.Mapper;

import com.institucional.WebIsp63.DTO.InscripcionDTO;
import com.institucional.WebIsp63.DTO.MesaExamenDTO;
import com.institucional.WebIsp63.Entity.MesaExamen;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MesaExamenMapper {

    MesaExamenMapper Instance= Mappers.getMapper(MesaExamenMapper.class);
    MesaExamenDTO toMesaExamenDTO(MesaExamen mesaExamen);

    MesaExamen toMesaExamen(MesaExamenDTO mesaExamenDTO);
    List<MesaExamenDTO> toMesaExamenesDTO(List<MesaExamen> mesaExamen);

    List<MesaExamenDTO>toMesaExamenes(List<MesaExamenDTO> mesaExamenDTOS);
}
