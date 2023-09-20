package com.institucional.WebIsp63.Service;

import com.institucional.WebIsp63.DTO.AdministradorDTO;
import com.institucional.WebIsp63.DTO.AlumnoDTO;
import com.institucional.WebIsp63.Entity.Administrador;
import com.institucional.WebIsp63.Excepcion.ResourseNotFounException;
import com.institucional.WebIsp63.Mapper.AdministradorMapper;
import com.institucional.WebIsp63.Repository.AdministradorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdministradorServiceImpl {
    @Autowired
    AdministradorRepository administradorRepository;
    @Autowired
    AdministradorMapper administradorMapper;

    @Transactional
    public AdministradorDTO guardarAdministrador(AdministradorDTO administradorDTO) {
        Administrador admi = new Administrador();
        admi.setPassword(admi.getPassword());
        admi.setTelefono(admi.getTelefono());
        admi.setId(admi.getId());
        admi.setCargo(admi.getCargo());
        admi.setEmail(admi.getEmail());
        admi.setNombre(admi.getNombre());
        admi.setApellido(admi.getApellido());
        admi.setCargo(admi.getCargo());
        administradorRepository.save(admi);
        return administradorDTO;
    }

    public void eliminarAdministrador(long id) {
        administradorRepository.deleteById(id);
    }

    public AdministradorDTO modificarAdministrador(AdministradorDTO admin) {
        Administrador objAdmin = new Administrador(admin.getCargo(), admin.getApellido(), admin.getNombre(), admin.getEmail(), admin.getDni(),
                admin.getPassword());
        administradorRepository.save(objAdmin);
        return admin;
    }

    public List<AdministradorDTO> findAllAdministrador(long id) {
        return administradorRepository.findAllById(Collections.singleton(id)).stream().map(admin ->
                new AdministradorDTO(admin.getCargo(), admin.getApellido(), admin.getNombre(), admin.getEmail(), admin.getDni()
                        , admin.getPassword())).collect(Collectors.toList());
    }
}
