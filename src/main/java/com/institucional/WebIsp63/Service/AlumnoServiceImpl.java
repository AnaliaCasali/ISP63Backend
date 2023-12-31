package com.institucional.WebIsp63.Service;
import com.institucional.WebIsp63.DTO.AlumnoDTO;
import com.institucional.WebIsp63.Entity.Alumno;
import com.institucional.WebIsp63.Excepcion.ResourseNotFounException;
import com.institucional.WebIsp63.Mapper.AlumnoMapper;
import com.institucional.WebIsp63.Repository.AlumnoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class AlumnoServiceImpl {
    @Autowired
    AlumnoRepository alumnoRepository;

    @Autowired
    AlumnoMapper alumnoMapper;
    @Transactional
    public  AlumnoDTO guardarAlumno (AlumnoDTO alumnoDTO) {
        Alumno alumno =new Alumno();
        alumno.setCarrera(alumnoDTO.getCarrera());
        alumno.setId(alumnoDTO.getId());
        alumno.setEstado(alumnoDTO.getEstado());
        alumno.setSede(alumnoDTO.getSede());
        alumno.setIngreso(alumnoDTO.getIngreso());
        alumno.setApellido(alumnoDTO.getApellido());
        alumno.setNombre(alumnoDTO.getNombre());
        alumno.setEmail(alumnoDTO.getEmail());
        alumno.setPassword(alumnoDTO.getPassword());
        alumno.setDni(alumnoDTO.getDni());
        alumno.setTelefono(alumnoDTO.getTelefono());
        alumnoRepository.save(alumno);
        return alumnoDTO;
    }
    public  void eliminarAlumno(long id){
        alumnoRepository.deleteById(id);
    }

   public AlumnoDTO modificarAlumno(AlumnoDTO alumno){
        Alumno objAlumno=new Alumno(alumno.getTelefono(),alumno.getNombre(),alumno.getApellido(),alumno.getEmail(),alumno.getDni(),
                alumno.getPassword(),alumno.getSede(),alumno.getCarrera(),alumno.getEstado(),alumno.getIngreso());
        alumnoRepository.save(objAlumno);
        return alumno;}
    public  List<AlumnoDTO> findAllAlumno(String nombre) {
        return  alumnoRepository.findBynombreContaining(nombre).stream().map(alumno ->
                new AlumnoDTO (alumno.getTelefono(),alumno.getNombre(),alumno.getApellido(),alumno.getEmail(),alumno.getDni(),
                        alumno.getPassword(),alumno.getSede(),alumno.getCarrera(),alumno.getEstado(),alumno.getIngreso())).
                collect(Collectors.toList());
        }
        public AlumnoDTO buscar (long id ) throws ResourseNotFounException {
            Alumno alumno = alumnoRepository.findById(id).orElseThrow(() ->
                    new ResourseNotFounException("alumno con id" + id + "no se encontro"));
            return alumnoMapper.toAlumnoDto(alumno);
        }
    }

    /*Optional<Alumno> AlumnoOptional = alumnoRepository.findById(id);
        if (AlumnoOptional.isEmpty()) {//esta vacio?
            throw new RuntimeException("Id valido");//genera msg de error
        }
        Alumno alumno=AlumnoOptional.get();//obtiene
        return  new AlumnoDTO (alumno.getTelefono(),alumno.getNombre(),alumno.getApellido(),alumno.getEmail(),alumno.getDni(),
                alumno.getPassword(),alumno.getSede(),alumno.getCarrera(),alumno.getEstado(),alumno.getIngreso());
    }*/