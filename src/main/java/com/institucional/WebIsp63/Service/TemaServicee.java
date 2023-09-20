package com.institucional.WebIsp63.Service;
import com.institucional.WebIsp63.DTO.TemaDTO;
import com.institucional.WebIsp63.Exception.ResourceNotFoundException;
import java.util.List;
public interface TemaServicee {
    public TemaDTO guardartema(TemaDTO temaDTO);
    public List<TemaDTO> findAll();
    public List<TemaDTO> findAllTema(String tema);
    public  void eliminarTema(long id);
    public TemaDTO modificartema (long id, TemaDTO temaDTO);
    public TemaDTO buscar(long id ) throws ResourceNotFoundException;
}