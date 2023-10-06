package com.institucional.WebIsp63.Service;
import com.institucional.WebIsp63.DTO.TemaDTO;
import com.institucional.WebIsp63.Exception.ResourceNotFoundException;
import java.util.List;
public interface TemaService {
    public TemaDTO guardartema(TemaDTO temaDTO);
    public List<TemaDTO> findAll();
    public List<TemaDTO> findAllTema(String tema);
    public  void eliminarTema(long id);
    public TemaDTO modificartema ( TemaDTO temaDTO);
    public TemaDTO buscar(long id ) throws ResourceNotFoundException;

    public boolean exists (long id);

}