package com.institucional.WebIsp63.Service;

import com.institucional.WebIsp63.DTO.AdministradorDTO;

import java.util.List;

public interface AdministradorService {
    public AdministradorDTO modificarAdministrador(AdministradorDTO admin);

    public List<AdministradorDTO> findAllAdministrador(long id);

    public void eliminarAdministrador(long id);
    public AdministradorDTO guardarAdministrador(AdministradorDTO administradorDTO);

    public  AdministradorDTO buscar (long id);
}
