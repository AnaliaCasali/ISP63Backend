package com.institucional.WebIsp63.Service;

import com.institucional.WebIsp63.DTO.BibliografiaDTO;
import com.institucional.WebIsp63.Exception.ResourceNotFoundException;

import java.util.List;

public interface BibliografiaService {
    public BibliografiaDTO guardarBibliografia(BibliografiaDTO bibliografiaDTO);
    public List<BibliografiaDTO> findAll();
    public List<BibliografiaDTO> findAllBibliografia(String tema);
    public void eliminarBibliografia(long id);
    public BibliografiaDTO modificarBibliografia(long id, BibliografiaDTO bibliografiaDTO);
    public BibliografiaDTO buscar (long id ) throws ResourceNotFoundException;
}
