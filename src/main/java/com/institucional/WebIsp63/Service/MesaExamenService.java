package com.institucional.WebIsp63.Service;

import com.institucional.WebIsp63.DTO.MesaExamenDTO;

import java.util.List;

public interface MesaExamenService {
    public MesaExamenDTO guardarMesa(MesaExamenDTO mesaExamenDTO);
    public List<MesaExamenDTO> findAll();
    public MesaExamenDTO findId(long id);
    public MesaExamenDTO modifcarMesa(Long id, MesaExamenDTO mesaExamenDTO);
    public void delete (long id);
}
