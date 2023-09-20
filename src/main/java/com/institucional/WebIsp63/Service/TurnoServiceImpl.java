package com.institucional.WebIsp63.Service;

import com.institucional.WebIsp63.DTO.TurnoDTO;
import com.institucional.WebIsp63.Entity.Turno;
import com.institucional.WebIsp63.Exception.ResourceNotFoundException;
import com.institucional.WebIsp63.Mapper.TurnoMapper;
import com.institucional.WebIsp63.Repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class TurnoServiceImpl {
    @Autowired
    TurnoRepository turnoRepository;

    @Autowired
    TurnoMapper turnoMapper;
    @Transactional
    public TurnoDTO guardarTurno(TurnoDTO turnoDTO) {
        Turno turno = new Turno();

        turno.setId(turnoDTO.getId());
        turno.setTurno(turnoDTO.getTurno());

        turnoRepository.save(turno);
        return turnoDTO;
    }

    public List<TurnoDTO> findAll() throws ResourceNotFoundException {
    return turnoMapper.toTurnosDTO(turnoRepository.findAll());
    }

    public TurnoDTO findId(long id) throws ResourceNotFoundException {
    Turno turno=turnoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Turno con id"+id+"no se encontro"));
    return turnoMapper.toTurnoDTO(turno);
    }

    public TurnoDTO modificar(long id, TurnoDTO turnoDTO) {
        Optional<Turno> optionalTurno = turnoRepository.findById(id);
        if (optionalTurno.isEmpty()) {
            throw new RuntimeException("Id Invalido");
        }
        Turno turno=optionalTurno.get();

        turno.setTurno(turnoDTO.getTurno());
        turnoRepository.save(turno);

        return turnoDTO;
    }

    public void deleteId(long id){
        turnoRepository.deleteById(id);
    }


}
