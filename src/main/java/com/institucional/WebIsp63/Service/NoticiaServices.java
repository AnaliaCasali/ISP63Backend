package com.institucional.WebIsp63.Service;

import com.institucional.WebIsp63.DTO.DTONoticia;
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

    public DTONoticia guardarNoticia(DTONoticia dtoNoticia){
        Noticia not = new Noticia();
        not.setBecas(dtoNoticia.getBecas());
        not.setId(dtoNoticia.getId());
        not.setFecha(dtoNoticia.getFecha());
        not.setNomCreador(dtoNoticia.getNomCreador());
        not.setLink(dtoNoticia.getLink());
        not.setSubTitulo(dtoNoticia.getSubTitulo());
        not.setTexto(dtoNoticia.getTexto());
        not.setUrl(dtoNoticia.getUrl());
        return dtoNoticia;
    }

    public List<DTONoticia> findAll() { return noticiaRepository.findAll().stream().map(noticia ->
            new DTONoticia(noticia.getId(), noticia.getTexto(), noticia.getFecha(), noticia.getLink(),noticia.getNomCreador(),noticia.getTexto(), noticia.getSubTitulo(), noticia.getUrl())).collect(Collectors.toList());
    }
    public  void eliminarNoticia(long id){noticiaRepository.deleteById(id);}

   
    public DTONoticia modificarAuto (long id, DTONoticia dtoNoticia){
        Optional<Noticia> noticiaOptional= noticiaRepository.findById(id);
        if(noticiaOptional.isEmpty()){
            throw new RuntimeException("Id invalido");
        }
        Noticia not=noticiaOptional.get();
        not.setBecas(dtoNoticia.getBecas());
        not.setId(dtoNoticia.getId());
        not.setFecha(dtoNoticia.getFecha());
        not.setNomCreador(dtoNoticia.getNomCreador());
        not.setLink(dtoNoticia.getLink());
        not.setSubTitulo(dtoNoticia.getSubTitulo());
        not.setTexto(dtoNoticia.getTexto());
        not.setUrl(dtoNoticia.getUrl());
        noticiaRepository.save(not);
        return dtoNoticia;


    }
    public DTONoticia buscar (long id ) {
        Optional<Noticia> noticiaOptional = noticiaRepository.findById(id);
       if (noticiaOptional.isEmpty()){
           throw new RuntimeException("Id valido");

        }
        Noticia not= noticiaOptional.get();//obtiene Auto
        return  new DTONoticia(not.getId(),not.getTexto(),not.getFecha(),not.getLink(),not.getNomCreador(),not.getTexto(),not.getSubTitulo(),not.getUrl());
    }
}
