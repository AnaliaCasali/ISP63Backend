package com.institucional.WebIsp63.Controller;
import com.institucional.WebIsp63.DTO.TemaDTO;
import com.institucional.WebIsp63.Exception.ResourceNotFoundException;
import com.institucional.WebIsp63.Service.TemaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tema")

public class TemaController {
    @Autowired
    TemaServiceImp temaService= new TemaServiceImp();
    @GetMapping("/tema")
    public List<TemaDTO> listarTodos(){
        return temaService.findAll();
    }
    @GetMapping("/temas/{libros}")

    public List<TemaDTO>listarTodostemas(@PathVariable String tema){

        return temaService.findAllTema(tema);
    }
    @PostMapping
    public TemaDTO guardar (@RequestBody TemaDTO temaDTO)
    {return temaService.guardartema(temaDTO);}

    @PutMapping("/libros/{id}")
    public  TemaDTO modificar (@PathVariable Long id, @RequestBody TemaDTO temaDTO){
        return temaService.modificartema(id,temaDTO);
    }
    @GetMapping("/{id}")
    public TemaDTO buscar (@PathVariable Long id) throws ResourceNotFoundException {
        return temaService.buscar(id);
    }
    @DeleteMapping("/{id}")
    public void borrar (@PathVariable long id){
        temaService.eliminarTema(id);
    }
}

