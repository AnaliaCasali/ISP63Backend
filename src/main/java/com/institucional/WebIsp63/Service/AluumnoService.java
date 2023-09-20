package com.institucional.WebIsp63.Service;

import com.institucional.WebIsp63.DTO.AlumnoDTO;
import com.institucional.WebIsp63.Excepcion.ResourseNotFounException;

import java.util.List;

public interface AluumnoService {
    public AlumnoDTO buscar (long id ) throws ResourseNotFounException;
    public List<AlumnoDTO> findAllAlumno(String nombre);
    public AlumnoDTO modificarAlumno(AlumnoDTO alumno);
    public  void eliminarAlumno(long id);
    public  AlumnoDTO guardarAlumno (AlumnoDTO alumnoDTO);
}
