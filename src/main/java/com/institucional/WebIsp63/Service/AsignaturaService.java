package com.institucional.WebIsp63.Service;

import com.institucional.WebIsp63.DTO.AsignaturaDTO;
import com.institucional.WebIsp63.DTO.CarreraDTO;
import com.institucional.WebIsp63.Entity.Asignatura;
import com.institucional.WebIsp63.Repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AsignaturaService {
    @Autowired
    AsignaturaRepository asignaturaRepository;

    @Transactional
    public AsignaturaDTO guardarAsignatura(AsignaturaDTO asignaturaDTO) {
        Asignatura asignatura = new Asignatura();

        asignatura.setId(asignaturaDTO.getId());
        asignatura.setAsignatura(asignaturaDTO.getAsignatura());
        asignatura.setAnio(asignaturaDTO.getAnio());
        asignatura.setCarrera(asignaturaDTO.getCarrera());
        asignatura.setDuracion(asignaturaDTO.getDuracion());
        asignatura.setTipo(asignaturaDTO.getTipo());
        asignatura.setCargaHorario(asignaturaDTO.getCargaHorario());
        asignatura.setCorrelativaCursar(asignaturaDTO.getCorrelativaCursar());
        asignatura.setCorrelativaRendir(asignaturaDTO.getCorrelativaRendir());

        asignaturaRepository.save(asignatura);
        return asignaturaDTO;


    }

    public List<AsignaturaDTO> findAll() {
        return asignaturaRepository.findAll().stream()
                .map(asignatura -> new AsignaturaDTO(asignatura.getId(), asignatura.getAsignatura(), asignatura.getTipo(), asignatura.getCarrera(), asignatura.getAnio(), asignatura.getCargaHorario(), asignatura.getDuracion(), asignatura.getCorrelativaRendir(), asignatura.getCorrelativaCursar()))
                .collect(Collectors.toList());
    }

    public AsignaturaDTO finId(long id) {
        Optional<Asignatura> optionalAsignatura = asignaturaRepository.findById(id);
        if (optionalAsignatura.isEmpty()) {
            throw new RuntimeException("Id Invalido");
        }

        Asignatura asignatura = optionalAsignatura.get();
        return new AsignaturaDTO(asignatura.getId(), asignatura.getAsignatura(), asignatura.getTipo(), asignatura.getCarrera(), asignatura.getAnio(), asignatura.getCargaHorario(), asignatura.getDuracion(), asignatura.getCorrelativaRendir(), asignatura.getCorrelativaCursar());


    }

    public AsignaturaDTO modificarAsignatura(long id, AsignaturaDTO asignaturaDTO) {
        Optional<Asignatura> optionalAsignatura = asignaturaRepository.findById(id);
        if (optionalAsignatura.isEmpty()) {
            throw new RuntimeException("Id Invalido");
        }
        Asignatura asignatura = optionalAsignatura.get();
        asignatura.setCorrelativaRendir(asignaturaDTO.getCorrelativaRendir());
        asignatura.setCorrelativaCursar(asignaturaDTO.getCorrelativaCursar());
        asignatura.setTipo(asignaturaDTO.getTipo());
        asignatura.setAnio(asignaturaDTO.getAnio());
        asignatura.setCarrera(asignaturaDTO.getCarrera());
        asignatura.setDuracion(asignaturaDTO.getDuracion());
        asignatura.setCargaHorario(asignaturaDTO.getCargaHorario());
        asignatura.setAsignatura(asignaturaDTO.getAsignatura());

        asignaturaRepository.save(asignatura);
        return asignaturaDTO;

    }

    public void delete(long id) {
        asignaturaRepository.deleteById(id);
    }
}
