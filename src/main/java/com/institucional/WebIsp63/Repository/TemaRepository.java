package com.institucional.WebIsp63.Repository;

import com.institucional.WebIsp63.Entity.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TemaRepository  extends JpaRepository <Tema,Long> {
    // @Query("Select t from Tema t WHERE nomtema='programacion' ")
  //   @Query(value = "Select t from temas t WHERE nomtema= :libros")//nativeQuery = true)
//public List<Tema> findAllTema (@Param("tema")String tema);
   // public List<Tema> finByBrandContaining(String tema);
    public List<Tema> findByTemaContainingOrderById(String tema);

}
