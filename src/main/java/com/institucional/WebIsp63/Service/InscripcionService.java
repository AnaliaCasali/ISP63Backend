package com.institucional.WebIsp63.Service;

import com.institucional.WebIsp63.DTO.InscripcionDTO;

import java.util.List;

public interface InscripcionService {

    public InscripcionDTO guardarInscripcion(InscripcionDTO inscripcionDTO);
    public List<InscripcionDTO> findAll();
    public InscripcionDTO findId(long id);
    public InscripcionDTO modificar(long id, InscripcionDTO inscripcionDTO);
    public void delete(long id);
}
