package com.institucional.WebIsp63.Service;

import com.institucional.WebIsp63.DTO.AsignaturaDTO;

import java.util.List;

public interface AsignaturaService {
    public AsignaturaDTO guardarAsignatura(AsignaturaDTO asignaturaDTO);

    public List<AsignaturaDTO> findAll();
    public AsignaturaDTO finId(long id);
    public AsignaturaDTO modificarAsignatura(long id, AsignaturaDTO asignaturaDTO);
    public void delete(long id);
}
