package com.institucional.WebIsp63.Service;

import com.institucional.WebIsp63.DTO.TurnoDTO;
import com.institucional.WebIsp63.Entity.Turno;
import com.institucional.WebIsp63.Repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TurnoService {
    @Autowired
    TurnoRepository turnoRepository;
    @Transactional
    public TurnoDTO guardarTurno(TurnoDTO turnoDTO) {
        Turno turno = new Turno();

        turno.setId(turnoDTO.getId());
        turno.setTurno(turnoDTO.getTurno());

        turnoRepository.save(turno);
        return turnoDTO;
    }

    public List<TurnoDTO> findAll() {
        return turnoRepository.findAll().stream()
                .map(turno -> new TurnoDTO(turno.getId(), turno.getTurno())).collect(Collectors.toList());

    }

    public TurnoDTO findId(long id) {
        Optional<Turno> optionalTurno = turnoRepository.findById(id);
        if (optionalTurno.isEmpty()) {
            throw new RuntimeException("Id Invalido");
        }
        Turno turno = optionalTurno.get();
        return new TurnoDTO(turno.getId(), turno.getTurno());
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
