package com.institucional.WebIsp63.Controller;

import com.institucional.WebIsp63.DTO.NoticiaDTO;
import com.institucional.WebIsp63.Service.NoticiaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/noticia")
public class NoticiaController {
    @Autowired
    NoticiaServices noticiaServices= new NoticiaServices();
    @GetMapping("/noti")
    public List<NoticiaDTO>listarTodos(){
        return noticiaServices.findAll();
    }
    @PostMapping
    public NoticiaDTO guardar (@RequestBody NoticiaDTO dtoNoticia)
    {return noticiaServices.guardarNoticia(dtoNoticia);}

    @PutMapping("/noti/{id}")
    public NoticiaDTO modificar (@PathVariable Long id, @RequestBody NoticiaDTO dtoNoticia) {
        return noticiaServices.modificarNoticia(id, dtoNoticia);}

      //  @GetMapping("/{id}")
       // public DTONoticia buscar (@PathVariable Long id) throws ResourceNotFoundException {
         //   return noticiaServices.buscar(id);
  //  }
    @DeleteMapping("/{id}")
    public void borrar (@PathVariable long id){
        noticiaServices.eliminarNoticia(id);
    }
}