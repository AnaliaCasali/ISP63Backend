package com.institucional.WebIsp63.Repository;

import com.institucional.WebIsp63.Entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlumnoRepository  extends JpaRepository<Alumno, Long> {
    @Query(value = "Select c from Alumno c WHERE brand:nombre", nativeQuery =true)
    public List<Alumno> findAllAlumno (@Param("nombre") String nombre);
    public  List<Alumno> findByNombreContaining(String nombre);
}
