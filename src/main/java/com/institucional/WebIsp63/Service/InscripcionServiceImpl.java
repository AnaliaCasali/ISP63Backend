package com.institucional.WebIsp63.Service;

import com.institucional.WebIsp63.DTO.InscripcionDTO;
import com.institucional.WebIsp63.Entity.Inscripcion;
import com.institucional.WebIsp63.Exception.ResourceNotFoundException;
import com.institucional.WebIsp63.Mapper.InscripcionMapper;
import com.institucional.WebIsp63.Repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InscripcionServiceImpl {
    @Autowired
    InscripcionRepository inscripcionRepository;

    @Autowired
    InscripcionMapper inscripcionMapper;

    @Transactional
    public InscripcionDTO guardarInscripcion(InscripcionDTO inscripcionDTO) {
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setId(inscripcionDTO.getId());
        inscripcion.setFecha(inscripcionDTO.getFecha());
        inscripcion.setMesaExamen(inscripcionDTO.getMesaExamen());
        inscripcionRepository.save(inscripcion);
        return inscripcionDTO;

    }

    public List<InscripcionDTO> findAll() throws ResourceNotFoundException {
      return  inscripcionMapper.toInscripcionesDTO(inscripcionRepository.findAll());
    }

    public InscripcionDTO findId(long id) throws ResourceNotFoundException {
       Inscripcion inscripcion=inscripcionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Inscripcion con id"+id+"no se encontro"));
        return inscripcionMapper.toInscripcionDTO(inscripcion);
    }

    public InscripcionDTO modificar(long id, InscripcionDTO inscripcionDTO){
        Optional<Inscripcion> inscripcionOptional=inscripcionRepository.findById(id);
        if (inscripcionOptional.isEmpty()){
            throw new RuntimeException("Id Invalido");
        }
         Inscripcion inscripcion=inscripcionOptional.get();

        inscripcion.setMesaExamen(inscripcionDTO.getMesaExamen());
        inscripcion.setFecha(inscripcionDTO.getFecha());

        inscripcionRepository.save(inscripcion);
        return inscripcionDTO;

    }

    public void delete(long id){
        inscripcionRepository.deleteById(id);
    }

}
