package com.institucional.WebIsp63.Service;

import com.institucional.WebIsp63.DTO.AdministradorDTO;
import com.institucional.WebIsp63.DTO.AlumnoDTO;
import com.institucional.WebIsp63.DTO.AsignaturaDTO;
import com.institucional.WebIsp63.Entity.Administrador;
import com.institucional.WebIsp63.Entity.Alumno;
import com.institucional.WebIsp63.Entity.Asignatura;
import com.institucional.WebIsp63.Excepcion.ResourseNotFounException;
import com.institucional.WebIsp63.Mapper.AdministradorMapper;
import com.institucional.WebIsp63.Repository.AdministradorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
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
        admi.setPassword(administradorDTO.getPassword());
        admi.setTelefono(administradorDTO.getTelefono());

        admi.setId(administradorDTO.getId());
        admi.setCargo(administradorDTO.getCargo());
        admi.setEmail(administradorDTO.getEmail());
        admi.setNombre(administradorDTO.getNombre());
        admi.setApellido(administradorDTO.getApellido());
        admi.setCargo(administradorDTO.getCargo());
        administradorRepository.save(admi);
        return administradorDTO;
    }
    /*public List<AdministradorDTO> findAllAdministrador(long id) {
        return administradorRepository.findAllById(Collections.singleton(id)).stream().map(admin ->
                new AdministradorDTO(admin.getCargo(), admin.getApellido(), admin.getNombre(), admin.getEmail(), admin.getDni()
                        , admin.getPassword())).collect(Collectors.toList());
    }*/
    public List<AdministradorDTO> findAll(){
        return administradorMapper.toAdministradorsDTO(administradorRepository.findAll());
    }
    public  AdministradorDTO buscar (long id) throws  ResourseNotFounException {
        Administrador administrador = administradorRepository.findById(id).orElseThrow(() ->
                new ResourseNotFounException("administrador con id" + id + "no se encontro"));
        return administradorMapper.toAdministradorDTO(administrador); }


    public void eliminarAdministrador(long id) {
        administradorRepository.deleteById(id);
    }
    public AdministradorDTO modificarAdministrador(long id, AdministradorDTO administradorDTO) {
        Optional<Administrador> optionalAdministrador= administradorRepository.findById(id);
        if (optionalAdministrador.isEmpty()){
            throw new RuntimeException("id invalido");
        }
        Administrador administrador= optionalAdministrador.get();
        administrador.setId(administradorDTO.getId());
        administrador.setDni(administradorDTO.getDni());
        administrador.setPassword(administradorDTO.getPassword());
        administrador.setEmail(administradorDTO.getEmail());
        administrador.setTelefono(administradorDTO.getTelefono());
        administrador.setNombre(administradorDTO.getNombre());
        administrador.setApellido(administradorDTO.getApellido());
        administrador.setCargo(administradorDTO.getCargo());
        administradorRepository.save(administrador);
        return administradorDTO;

    }
}
