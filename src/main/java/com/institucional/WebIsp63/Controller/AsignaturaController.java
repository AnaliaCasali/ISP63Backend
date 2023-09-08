package com.institucional.WebIsp63.Controller;

import com.institucional.WebIsp63.DTO.AsignaturaDTO;
import com.institucional.WebIsp63.Service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignatura")
public class AsignaturaController {
    @Autowired
    AsignaturaService asignaturaService= new AsignaturaService();
    @PostMapping
    public AsignaturaDTO savetq (@RequestBody AsignaturaDTO asignaturaDTO){
            return asignaturaService.guardarAsignatura(asignaturaDTO);
    }

    @GetMapping
    public List<AsignaturaDTO> findAll(){
        return asignaturaService.findAll();
    }

    @GetMapping("/{id}")
    public AsignaturaDTO findId(@PathVariable  long id){
        return asignaturaService.finId(id);
    }

    @PutMapping ("/asignatura/{id}")
    public AsignaturaDTO modifcar(@PathVariable long id,@RequestBody AsignaturaDTO asignaturaDTO){
        return asignaturaService.modificarAsignatura(id,asignaturaDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        asignaturaService.delete(id);
    }

}
