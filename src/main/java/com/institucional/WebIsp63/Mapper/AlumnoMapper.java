package com.institucional.WebIsp63.Mapper;

import com.institucional.WebIsp63.DTO.AlumnoDTO;
import com.institucional.WebIsp63.Entity.Alumno;
import org.apache.catalina.mapper.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@org.mapstruct.Mapper(componentModel="Spring")
public interface AlumnoMapper {
AlumnoMapper INSTANCE= Mappers.getMapper(AlumnoMapper.class);
AlumnoDTO toAlumnoDto (Alumno alumno);
Alumno toAlumno (AlumnoDTO alumnoDTO);
List<AlumnoDTO> toAlumnosDTO(List<Alumno>alumnos);
List<Alumno> toAlumnos(List<AlumnoDTO>alumnoDTOS);

}