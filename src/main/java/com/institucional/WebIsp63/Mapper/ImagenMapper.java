package com.institucional.WebIsp63.Mapper;

import com.institucional.WebIsp63.DTO.ImagenDTO;
import com.institucional.WebIsp63.Entity.Imagen;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.awt.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ImagenMapper {
    static final ImagenMapper Instance= Mappers.getMapper(ImagenMapper.class);
    ImagenDTO toImagenDTO(Imagen imagen);

    Imagen toImagen(ImagenDTO DTO);
    List<ImagenDTO> toImagenesDTO(List<Imagen> imagenes);

    List<Imagen> toImagenes(List<ImagenDTO> imagenesDTO);
}
