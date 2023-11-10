package com.institucional.WebIsp63.Mapper;

import com.institucional.WebIsp63.DTO.NoticiaDTO;
import com.institucional.WebIsp63.Entity.Noticia;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@org.mapstruct.Mapper(componentModel="Spring", uses = {AdministradorMapper .class } )
//@Mapper(componentModel = "spring", uses={AdministradorMapper.class})
public interface NoticiaMapper {
    NoticiaMapper INSTANCE= Mappers.getMapper(NoticiaMapper.class);
    NoticiaDTO toNoticiaDTO(Noticia noticia);

    Noticia toNoticia(NoticiaDTO DTO);
    List<NoticiaDTO> toNoticiasDTO(List<Noticia> noticias);
    List<Noticia>toNoticias(List<NoticiaDTO> noticiaDTOS);
}
