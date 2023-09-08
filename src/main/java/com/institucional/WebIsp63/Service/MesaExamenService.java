package com.institucional.WebIsp63.Service;
import com.institucional.WebIsp63.DTO.MesaExamenDTO;
import com.institucional.WebIsp63.Entity.MesaExamen;
import com.institucional.WebIsp63.Repository.MesaExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MesaExamenService {
    @Autowired
    MesaExamenRepository mesaExamenRepository;

    @Transactional
    public MesaExamenDTO guardarMesa(MesaExamenDTO mesaExamenDTO) {
        MesaExamen examen = new MesaExamen();

        examen.setId(mesaExamenDTO.getId());
        examen.setFecha(mesaExamenDTO.getFecha());
        examen.setAsignatura(mesaExamenDTO.getAsignatura());
        examen.setHorario(mesaExamenDTO.getHorario());
        examen.setTurno(mesaExamenDTO.getTurno());
        examen.setTribunal(mesaExamenDTO.getTribunal());
        mesaExamenRepository.save(examen);
        return mesaExamenDTO;

    }

    public List<MesaExamenDTO> findAll() {
        return mesaExamenRepository.findAll()
                .stream().map(mesaExamen -> new MesaExamenDTO(mesaExamen.getId(),mesaExamen.getFecha(), mesaExamen.getTurno(), mesaExamen.getAsignatura(), mesaExamen.getHorario(),mesaExamen.getTribunal()))
                .collect(Collectors.toList());
    }

    public MesaExamenDTO findId(long id){
        Optional<MesaExamen> optionalMesaExamen = mesaExamenRepository.findById(id);
            if (optionalMesaExamen.isEmpty()){
                   throw new RuntimeException("Id Invalido");
            }
            MesaExamen mesaExamen=optionalMesaExamen.get();
            return new MesaExamenDTO(mesaExamen.getId(),mesaExamen.getFecha(),mesaExamen.getTurno(),mesaExamen.getAsignatura(),mesaExamen.getHorario(),mesaExamen.getTribunal());

    }

    public MesaExamenDTO modifcarMesa(Long id, MesaExamenDTO mesaExamenDTO){
        Optional<MesaExamen> optionalMesaExamen=mesaExamenRepository.findById(id);

        if (optionalMesaExamen.isEmpty()){
            throw new RuntimeException("Id Invalido");
        }
        MesaExamen mesaExamen=optionalMesaExamen.get();

        mesaExamen.setTurno(mesaExamenDTO.getTurno());
        mesaExamen.setTribunal(mesaExamenDTO.getTribunal());
        mesaExamen.setFecha(mesaExamenDTO.getFecha());
        mesaExamen.setAsignatura(mesaExamenDTO.getAsignatura());
        mesaExamen.setHorario(mesaExamenDTO.getHorario());
        mesaExamenRepository.save(mesaExamen);
        return mesaExamenDTO;
    }
}
