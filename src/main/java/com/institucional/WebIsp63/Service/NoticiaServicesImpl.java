package com.institucional.WebIsp63.Service;


import com.institucional.WebIsp63.DTO.NoticiaDTO;
import com.institucional.WebIsp63.Entity.Noticia;
import com.institucional.WebIsp63.Exception.ResourceNotFoundException;
import com.institucional.WebIsp63.Mapper.AdministradorMapper;
import com.institucional.WebIsp63.Mapper.NoticiaMapper;
import com.institucional.WebIsp63.Repository.NoticiaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class NoticiaServicesImpl  {
    @Autowired
    NoticiaRepository noticiaRepository;
    @Autowired
    NoticiaMapper noticiaMapper;
    @Transactional

    public NoticiaDTO guardarNoticia(NoticiaDTO noticiaDTO){
        Noticia not = new Noticia();
        not.setBeca(noticiaDTO.isBecas());

        not.setId(noticiaDTO.getId());
        not.setFecha(noticiaDTO.getFecha());
        not.setAdministrador(AdministradorMapper.INSTANCE.toAdministrador(noticiaDTO.getAdministrador()));
        not.setLink(noticiaDTO.getLink());
        not.setSubTitulo(noticiaDTO.getSubTitulo());
        not.setTitulo(noticiaDTO.getTitulo());
        not.setTexto(noticiaDTO.getTexto());
        not.setUrl(noticiaDTO.getUrl());
        noticiaRepository.save(not);
        return noticiaDTO;
    }

    public List<NoticiaDTO> findAll(){
        //{ return noticiaRepository.findAll().stream().map(noticia ->
        // new NoticiaDTO(noticia.getId(), noticia.getTexto(), noticia.getFecha(), noticia.getLink(), noticia.getNomcreador(), noticia.getTexto(), noticia.getSubtitulo(), noticia.getUrl())).collect(Collectors.toList());

        return noticiaMapper.toNoticiasDTO(noticiaRepository.findAll());
    }
    public List<NoticiaDTO> findTresUltimas(){
        //{ return noticiaRepository.findAll().stream().map(noticia ->
        // new NoticiaDTO(noticia.getId(), noticia.getTexto(), noticia.getFecha(), noticia.getLink(), noticia.getNomcreador(), noticia.getTexto(), noticia.getSubtitulo(), noticia.getUrl())).collect(Collectors.toList());

        return noticiaMapper.toNoticiasDTO(noticiaRepository.findTresUltimas());
    }
    public  void deleteNoticia(long id)
    {noticiaRepository.deleteById(id);}
    public NoticiaDTO modificarNoticia (NoticiaDTO noticiaDTO){
        Optional<Noticia> noticiaOptional= noticiaRepository.findById(noticiaDTO.getId());
        if(noticiaOptional.isEmpty()){
            throw new RuntimeException("Id invalido");
        }
        Noticia not=noticiaOptional.get();
        not.setBeca(noticiaDTO.isBecas());
        not.setId(noticiaDTO.getId());
        not.setFecha(noticiaDTO.getFecha());
        not.setAdministrador(AdministradorMapper.INSTANCE.toAdministrador(noticiaDTO.getAdministrador()));

        not.setLink(noticiaDTO.getLink());
        not.setSubTitulo(noticiaDTO.getSubTitulo());
        not.setTitulo(noticiaDTO.getTitulo());
        not.setTexto(noticiaDTO.getTexto());
        not.setUrl(noticiaDTO.getUrl());
        noticiaRepository.save(not);
        return noticiaDTO;


    }
    public NoticiaDTO buscar (long id ) throws ResourceNotFoundException {
        Noticia Noticia =noticiaRepository.findById(id).orElseThrow(    ()-> new ResourceNotFoundException("Noticia con id"+ id + "no se encontro"));
        return  noticiaMapper.toNoticiaDTO(Noticia);
    }
}
