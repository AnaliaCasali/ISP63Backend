package com.institucional.WebIsp63.Service;

import com.institucional.WebIsp63.DTO.CarreraDTO;


import java.util.List;

public interface CarreraService {
    public CarreraDTO GuardarCarrera(CarreraDTO carreraDTO);
    public List<CarreraDTO> findAllBySede(String sede);
    public List<CarreraDTO> findAll();

    public CarreraDTO finId(long id);
    public CarreraDTO modificarCarrera(Long id, CarreraDTO carreraDTO);
    public void Delete(long id);
}
