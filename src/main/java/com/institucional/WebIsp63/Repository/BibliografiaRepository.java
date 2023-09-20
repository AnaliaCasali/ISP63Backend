package com.institucional.WebIsp63.Repository;

import com.institucional.WebIsp63.Entity.Bibliografia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BibliografiaRepository extends JpaRepository <Bibliografia,Long> {
 // @Query("Select b from Biblioteca b WHERE tema='programacion' ")
 // @Query(value = "Select b from temas b WHERE tema= :libros")//nativeQuery = true)
//public List<Biblioteca> findAllBiblioteca (@Param("tema")String tema);
 // public List<Biblioteca> finByBrandContaining(String tema);
   public List<Bibliografia> findByTemaContainingOrderById(String tema);
}
