package com.institucional.WebIsp63.Repository;

import com.institucional.WebIsp63.Entity.Bibliografia;
import com.institucional.WebIsp63.Entity.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoticiaRepository extends JpaRepository <Noticia, Long> {
    //  @Query("Select n from Noticia n WHERE texto='programacion' ")
    //   @Query(value = "Select n from Noticia n WHERE texto= :libros")//nativeQuery = true)
//public List<Noticia> findAllNoticia (@Param("texto")String programacion);
    //  public List<Noticia> finBytextoContaining(String programacion );


    public List<Noticia> findByTextoContainingOrderById(String programacion);
    @Query(value = "SELECT * FROM noticia as n order by n.id desc limit 3", nativeQuery = true)
    public List<Noticia> findTresUltimas();

}
