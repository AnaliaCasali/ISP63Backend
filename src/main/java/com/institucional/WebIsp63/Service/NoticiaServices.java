package com.institucional.WebIsp63.Service;

import com.institucional.WebIsp63.DTO.NoticiaDTO;
import com.institucional.WebIsp63.DTO.TemaDTO;

import java.util.List;

public interface NoticiaServices {
    public NoticiaDTO guardarNoticia(NoticiaDTO dtoNoticia);
    public List<NoticiaDTO> findAll();
    public List<TemaDTO> findAllNoticia(String programacion);
    public  void deleteNoticia(long id);
    public NoticiaDTO modificarnoticia ( NoticiaDTO dtoNoticia);

    public NoticiaDTO delete (long id );
}
