package com.institucional.WebIsp63.Repository;

import com.institucional.WebIsp63.Entity.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarreraRepository extends JpaRepository <Carrera,Long> {


public List<Carrera> findDistinctBynombreContaining(String nombre);

public List<Carrera> findBynombreLike(String nombre);

public List<Carrera> findBycampoOcupacionalContaining(String campo);

public List<Carrera> findBysedeContaining(String sede);





}