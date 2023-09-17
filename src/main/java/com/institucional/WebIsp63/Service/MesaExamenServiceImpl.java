package com.institucional.WebIsp63.Service;
import com.institucional.WebIsp63.DTO.MesaExamenDTO;
import com.institucional.WebIsp63.Entity.MesaExamen;
import com.institucional.WebIsp63.Exception.ResourceNotFoundException;
import com.institucional.WebIsp63.Mapper.MesaExamenMapper;
import com.institucional.WebIsp63.Repository.MesaExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MesaExamenServiceImpl {
    @Autowired
    MesaExamenRepository mesaExamenRepository;

    @Autowired
    MesaExamenMapper mesaExamenMapper;

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

    public List<MesaExamenDTO> findAll() throws ResourceNotFoundException {
      return  mesaExamenMapper.toMesaExamenesDTO(mesaExamenRepository.findAll());
    }

    public MesaExamenDTO findId(long id) throws ResourceNotFoundException {
    MesaExamen mesaExamen=mesaExamenRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(("Mesa de examen con id"+id+"no se encontro")));
    return mesaExamenMapper.toMesaExamenDTO(mesaExamen);
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

    public void delete (long id){
        mesaExamenRepository.deleteById(id);
    }
}
