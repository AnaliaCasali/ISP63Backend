package com.institucional.WebIsp63.Mapper;

import com.institucional.WebIsp63.DTO.AdministradorDTO;
import com.institucional.WebIsp63.Entity.Administrador;
import org.mapstruct.factory.Mappers;

import java.util.List;

@org.mapstruct.Mapper(componentModel="Spring")
public interface AdministradorMapper {
    AdministradorMapper INSTANCE = Mappers.getMapper(AdministradorMapper.class);
    AdministradorDTO toAdministradorDTO (AdministradorDTO administradorDTO);
    Administrador toAdministrador (Administrador administrador);

    List<AdministradorDTO> toAdministradorsDTO(List<Administrador> administradors);
    List<Administrador> toAdministradors (List<AdministradorDTO> administradorDTOS);
}
