package com.institucional.WebIsp63.Repository;

import com.institucional.WebIsp63.Entity.Administrador;
import com.institucional.WebIsp63.Entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdministradorRepository  extends JpaRepository<Administrador, Long> {
    @Query(value = "Select c from Administrador c WHERE brand:nombre", nativeQuery =true)
    public List<Administrador> findAllAlumno (@Param("nombre") String nombre);
    public  List<Administrador> findBynombreContaining(String nombre);
}
