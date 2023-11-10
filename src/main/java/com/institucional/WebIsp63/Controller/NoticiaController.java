package com.institucional.WebIsp63.Controller;

import com.institucional.WebIsp63.DTO.NoticiaDTO;

import com.institucional.WebIsp63.Exception.ResourceNotFoundException;

import com.institucional.WebIsp63.Service.NoticiaServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/noticia")
public class NoticiaController {

    @Autowired
    NoticiaServicesImpl noticiaService= new NoticiaServicesImpl();
    @GetMapping
    public List<NoticiaDTO> listarTodos()throws ResourceNotFoundException {
        return noticiaService.findAll();
    }
    @GetMapping("/tresultimas")
    public List<NoticiaDTO> listarTresUltimas()throws ResourceNotFoundException {
        return noticiaService.findTresUltimas();
    }
    //    @GetMapping("/noticia/{texto}")

    // public List<NoticiaDTO>listarTodosNoticias(@PathVariable String programacion){

    //  return noticiaService.findAllNoticia(programacion);
    //  }
    @PostMapping
    public NoticiaDTO guardar (@RequestBody NoticiaDTO noticiaDTO)
    {return noticiaService.guardarNoticia(noticiaDTO);}

    @PutMapping()
    public  NoticiaDTO modificar ( @RequestBody NoticiaDTO noticiaDTO){
        return noticiaService.modificarNoticia(noticiaDTO);
    }
    @GetMapping("/{id}")
    public NoticiaDTO buscar (@PathVariable Long id) throws ResourceNotFoundException {
        return noticiaService.buscar(id);
    }
    @DeleteMapping("/{id}")
    public void delete (@PathVariable long id){
        noticiaService.deleteNoticia(id);
    }
};

