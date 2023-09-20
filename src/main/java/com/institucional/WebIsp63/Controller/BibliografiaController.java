package com.institucional.WebIsp63.Controller;

import com.institucional.WebIsp63.DTO.BibliografiaDTO;
import com.institucional.WebIsp63.Entity.Bibliografia;
import com.institucional.WebIsp63.Exception.ResourceNotFoundException;
import com.institucional.WebIsp63.Service.BibliografiaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bibliografia")
public class BibliografiaController {
    @Autowired
    BibliografiaServiceImp bibliografiaServices = new BibliografiaServiceImp();
    @GetMapping("/bibliografia")
    public List<BibliografiaDTO> listarTodos()throws ResourceNotFoundException {
        return bibliografiaServices.findAll();
    }
        @GetMapping("/temas/{libros}")

        public List<BibliografiaDTO>listarTodoslibrosporTemas(@PathVariable String tema){

            return bibliografiaServices.findAllBibliografia(tema);
        }

    @GetMapping("/{id}")
    public BibliografiaDTO buscar (@PathVariable Long id) throws ResourceNotFoundException {
        return bibliografiaServices.buscar(id);
    }
    @PostMapping
    public BibliografiaDTO guardar (@RequestBody BibliografiaDTO bibliografiaDTO){return bibliografiaServices.guardarBibliografia( bibliografiaDTO);}
/*
    @PutMapping("/temas/{id}")
    public Bibliografia modificar(@PathVariable Long id, @RequestBody BibliografiaDTO bibliografiaDTO){
        return bibliografiaServices.modificarBibliografia(id,bibliografiaDTO);
    }
*/
        @DeleteMapping("/{id}")
        public void borrar (@PathVariable long id){
            bibliografiaServices.eliminarBibliografia(id);
        }
    }

