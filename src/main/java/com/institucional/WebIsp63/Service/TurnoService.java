package com.institucional.WebIsp63.Service;

import com.institucional.WebIsp63.DTO.TurnoDTO;

import java.util.List;

public interface TurnoService {
    public TurnoDTO guardarTurno(TurnoDTO turnoDTO);
    public List<TurnoDTO> findAll();
    public TurnoDTO findId(long id);
    public TurnoDTO modificar(long id, TurnoDTO turnoDTO);
    public void deleteId(long id);
}
