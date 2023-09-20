package com.institucional.WebIsp63.Service;

import com.institucional.WebIsp63.DTO.NoticiaDTO;
import com.institucional.WebIsp63.Entity.Noticia;
import com.institucional.WebIsp63.Repository.NoticiaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NoticiaServices {
    @Autowired
    NoticiaRepository noticiaRepository;
    @Transactional

    public NoticiaDTO guardarNoticia(NoticiaDTO dtoNoticia){
        Noticia not = new Noticia();
        not.setBecas(dtoNoticia.getBecas());
        not.setId(dtoNoticia.getId());
        not.setFecha(dtoNoticia.getFecha());
        not.setNomcreador(dtoNoticia.getNomCreador());
        not.setLink(dtoNoticia.getLink());
        not.setSubtitulo(dtoNoticia.getSubTitulo());
        not.setTexto(dtoNoticia.getTexto());
        not.setUrl(dtoNoticia.getUrl());
        return dtoNoticia;
    }

    public List<NoticiaDTO> findAll() { return noticiaRepository.findAll().stream().map(noticia ->
            new NoticiaDTO(noticia.getId(), noticia.getTexto(), noticia.getFecha(), noticia.getLink(), noticia.getNomcreador(), noticia.getTexto(), noticia.getSubtitulo(), noticia.getUrl())).collect(Collectors.toList());
    }
    public  void eliminarNoticia(long id){noticiaRepository.deleteById(id);}


    public NoticiaDTO modificarNoticia (long id, NoticiaDTO dtoNoticia){
        Optional<Noticia> noticiaOptional= noticiaRepository.findById(id);
        if(noticiaOptional.isEmpty()){
            throw new RuntimeException("Id invalido");
        }
        Noticia not=noticiaOptional.get();
        not.setBecas(dtoNoticia.getBecas());
        not.setId(dtoNoticia.getId());
        not.setFecha(dtoNoticia.getFecha());
        not.setNomcreador(dtoNoticia.getNomCreador());
        not.setLink(dtoNoticia.getLink());
        not.setSubtitulo(dtoNoticia.getSubTitulo());
        not.setTexto(dtoNoticia.getTexto());
        not.setUrl(dtoNoticia.getUrl());
        noticiaRepository.save(not);
        return dtoNoticia;


    }
    public NoticiaDTO buscar (long id ) {
        Optional<Noticia> noticiaOptional = noticiaRepository.findById(id);
       if (noticiaOptional.isEmpty()){
           throw new RuntimeException("Id valido");

        }
        Noticia not= noticiaOptional.get();
        return  new NoticiaDTO(not.getId(),not.getTexto(),not.getFecha(),not.getLink(),not.getNomcreador(),not.getTexto(),not.getSubtitulo(),not.getUrl());
    }
}
