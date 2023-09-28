package com.institucional.WebIsp63.Controller;

import com.institucional.WebIsp63.DTO.NoticiaDTO;
import com.institucional.WebIsp63.Service.NoticiaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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


  /*      @PostMapping(produces = MediaType.IMAGE_PNG_VALUE)
        public ResponseEntity<byte[]> createNoticia(@RequestPart String text, @RequestPart String size, @RequestPart String color, @RequestPart String backgroundColor, @RequestPart MultipartFile imageFile) throws IOException {

        }
*/

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