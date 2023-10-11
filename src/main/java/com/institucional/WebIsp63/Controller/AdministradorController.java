package com.institucional.WebIsp63.Controller;

import com.institucional.WebIsp63.DTO.AdministradorDTO;
import com.institucional.WebIsp63.DTO.AlumnoDTO;
import com.institucional.WebIsp63.Excepcion.ResourseNotFounException;
import com.institucional.WebIsp63.Service.AdministradorService;
import com.institucional.WebIsp63.Service.AdministradorServiceImpl;
import com.institucional.WebIsp63.Service.AlumnoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {
    @Autowired
    AdministradorServiceImpl administradorService= new AdministradorServiceImpl();
    /*@GetMapping("/administrador/{id}")
    public  List<AdministradorDTO> listarAdministrador (@PathVariable long id){
        return administradorService.findAllAdministrador(id);
    }*/
    @GetMapping("/{id}")
    public  AdministradorDTO buscar (@PathVariable long id ) throws  ResourseNotFounException, ResourseNotFounException
    {return administradorService.buscar(id);}
    @GetMapping
    public List<AdministradorDTO>listarTodos(){return administradorService.findAll();}
    @PostMapping
    public  AdministradorDTO guardarAdministrador (@RequestBody AdministradorDTO administradorDTO)
    {return  administradorService.guardarAdministrador(administradorDTO);}

    @PutMapping("/alumno/{id}")
    public AdministradorDTO modificarAlumno (@PathVariable Long id, @RequestBody AdministradorDTO administradorDTO)
    {return  administradorService.modificarAdministrador(id, administradorDTO);}
    @DeleteMapping("/{id}")
    public  void borrar (@PathVariable long id){ administradorService.eliminarAdministrador(id);}

}
