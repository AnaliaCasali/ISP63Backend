package com.institucional.WebIsp63.Service;
import com.institucional.WebIsp63.DTO.AlumnoDTO;
import com.institucional.WebIsp63.Entity.Alumno;
import com.institucional.WebIsp63.Excepcion.ResourseNotFounException;
import com.institucional.WebIsp63.Mapper.AlumnoMapper;
import com.institucional.WebIsp63.Mapper.CarreraMapper;
import com.institucional.WebIsp63.Repository.AlumnoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl {
    @Autowired
    AlumnoRepository alumnoRepository;
    @Autowired
    AlumnoMapper alumnoMapper;
    @Transactional
    public  AlumnoDTO guardarAlumno (AlumnoDTO alumnoDTO) {
        Alumno alumno =new Alumno();
        alumno.setCarrera(CarreraMapper.Instance.toCarrera( alumnoDTO.getCarrera()));
        alumno.setEstado(alumnoDTO.isEstado());
        alumno.setId(alumnoDTO.getId());
        alumno.setApellido(alumnoDTO.getApellido());
        alumno.setNombre(alumnoDTO.getNombre());
        alumno.setEmail(alumnoDTO.getEmail());
        alumno.setPassword(alumnoDTO.getPassword());
        alumno.setDni(alumnoDTO.getDni());
        alumno.setTelefono(alumnoDTO.getTelefono());
        alumnoRepository.save(alumno);
        return alumnoDTO;
    }
    public  void delete(long id){
        alumnoRepository.deleteById(id);
    }

    public List<AlumnoDTO> findAll(){
        return alumnoMapper.toAlumnosDTO(alumnoRepository.findAll());
    }

    public AlumnoDTO buscar (long id ) throws ResourseNotFounException {
        Alumno alumno = alumnoRepository.findById(id).orElseThrow(() ->
                new ResourseNotFounException("alumno con id" + id + "no se encontro"));
        return alumnoMapper.toAlumnoDTO(alumno);
    }
    public AlumnoDTO modificarAlumno(AlumnoDTO alumnoDTO) {
        Optional<Alumno> optionalAlumno= alumnoRepository.findById(alumnoDTO.getId());
        if (optionalAlumno.isEmpty()){
            throw new RuntimeException("id invalido");
        }
        Alumno alumno= optionalAlumno.get();
        alumno.setCarrera(CarreraMapper.Instance.toCarrera( alumnoDTO.getCarrera()));

        alumno.setEstado(alumnoDTO.isEstado());
        alumno.setId(alumnoDTO.getId());
        alumno.setApellido(alumnoDTO.getApellido());
        alumno.setNombre(alumnoDTO.getNombre());
        alumno.setEmail(alumnoDTO.getEmail());
        alumno.setPassword(alumnoDTO.getPassword());
        alumno.setDni(alumnoDTO.getDni());
        alumno.setTelefono(alumnoDTO.getTelefono());
        alumnoRepository.save(alumno);
        return  alumnoDTO;


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