package com.institucional.WebIsp63.Service;

import com.institucional.WebIsp63.DTO.CarreraDTO;
import com.institucional.WebIsp63.Entity.Imagen;


import java.util.List;

public interface CarreraService {
    public CarreraDTO save(CarreraDTO carreraDTO, Imagen imagen) ;
    public List<CarreraDTO> findAllBySede(String sede);
    public List<CarreraDTO> findAll();

    public CarreraDTO finId(long id);
    public CarreraDTO modificarCarrera(Long id, CarreraDTO carreraDTO);
    public void Delete(long id);
    public boolean exists (long id);



}
