package com.institucional.WebIsp63.Controller;

import com.institucional.WebIsp63.DTO.DTONoticia;
import com.institucional.WebIsp63.Service.NoticiaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Noticia")
public class NoticiaController {
    @Autowired
    NoticiaServices noticiaServices= new NoticiaServices();
    @GetMapping
    public List<DTONoticia>listarTodos(){
        return noticiaServices.findAll();
    }
    @PostMapping
    public DTONoticia guardar (@RequestBody DTONoticia dtoNoticia){return noticiaServices.guardarNoticia(dtoNoticia);}

    @PutMapping("/noticia/{id}")
    public  DTONoticia modificar (@PathVariable Long id, @RequestBody DTONoticia dtoNoticia){
        return noticiaServices.modificarAuto(id,dtoNoticia);
    }
    @DeleteMapping("/{id}")
    public void borrar (@PathVariable long id){
        noticiaServices.eliminarNoticia(id);
    }
}