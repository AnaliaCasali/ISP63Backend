package com.institucional.WebIsp63.Controller;
import com.institucional.WebIsp63.DTO.AlumnoDTO;
import com.institucional.WebIsp63.Excepcion.ResourseNotFounException;
import com.institucional.WebIsp63.Service.AlumnoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/alumno")
public class AlumnoController {
    @Autowired
    AlumnoServiceImpl alumnoService=new AlumnoServiceImpl();
    @GetMapping("/alumno/{nombre}")
    public List<AlumnoDTO>listarAlumno(@PathVariable String nombre)
    {return alumnoService.findAllAlumno(nombre);}
    @PostMapping
    public AlumnoDTO guardar(@RequestBody AlumnoDTO alumnoDTO){return alumnoService.guardarAlumno(alumnoDTO);}
    @GetMapping("/{id}")
    public AlumnoDTO buscar (@PathVariable Long id) throws ResourseNotFounException, ResourseNotFounException  {
        return alumnoService.buscar(id);
    }
    @PutMapping("/alumno/{id}")
    public AlumnoDTO modificar (@PathVariable Long id, @RequestBody AlumnoDTO alumno){
        return  alumnoService.modificarAlumno(alumno);}
    @DeleteMapping("/{id}")
    public void borrar (@PathVariable long id){
        alumnoService.eliminarAlumno(id);
    }

}
