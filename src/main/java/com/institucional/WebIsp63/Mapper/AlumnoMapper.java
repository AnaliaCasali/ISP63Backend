package com.institucional.WebIsp63.Mapper;

import com.institucional.WebIsp63.DTO.AlumnoDTO;
import com.institucional.WebIsp63.Entity.Alumno;
import org.apache.catalina.mapper.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@org.mapstruct.Mapper(componentModel="Spring", uses= {CarreraMapper.class})
public interface AlumnoMapper {
    com.institucional.WebIsp63.Mapper.AlumnoMapper INSTANCE= Mappers.getMapper(com.institucional.WebIsp63.Mapper.AlumnoMapper.class);
    AlumnoDTO toAlumnoDTO (Alumno alumno);
    Alumno toAlumno (AlumnoDTO alumnoDTO);
    List<AlumnoDTO> toAlumnosDTO(List<Alumno>alumnos);
    List<Alumno> toAlumnos(List<AlumnoDTO>alumnoDTOS);

}