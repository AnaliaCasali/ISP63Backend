package com.institucional.WebIsp63.Mapper;

//import org.mapstruct.Mapper;
import com.institucional.WebIsp63.DTO.BibliografiaDTO;
import com.institucional.WebIsp63.Entity.Bibliografia;
import org.mapstruct.factory.Mappers;

import java.util.List;

@org.mapstruct.Mapper(componentModel="Spring", uses = { TemaMapper.class } )

//@Mapper(componentModel = "spring", uses = { TemaMapper.class } )
public interface BibliografiaMapper {
    BibliografiaMapper INSTANCE= Mappers.getMapper(BibliografiaMapper.class);
    BibliografiaDTO toBibliografiaDTO(Bibliografia bibliografia);

    Bibliografia toBiblioteca (BibliografiaDTO DTO);
    List<BibliografiaDTO> toBibliografiasDTO(List<Bibliografia> bibliografias);
    List<Bibliografia>toBibliografias(List<BibliografiaDTO> bibliografiasDTo);

}
