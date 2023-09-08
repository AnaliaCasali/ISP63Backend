package com.institucional.WebIsp63.Controller;

import com.institucional.WebIsp63.DTO.TurnoDTO;
import com.institucional.WebIsp63.Service.TurnoService;
import org.hibernate.type.descriptor.jdbc.TimestampUtcAsJdbcTimestampJdbcType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turno")
public class TurnoController {
    @Autowired
    TurnoService turnoService = new TurnoService();

    @GetMapping
    public List<TurnoDTO> findAll() {
        return turnoService.findAll();
    }

    @GetMapping("/{id}")
    public TurnoDTO findId(@PathVariable long id) {
        return turnoService.findId(id);
    }

    @PutMapping("/turno/{id}")
    public TurnoDTO modificar(@PathVariable long id, @RequestBody TurnoDTO turnoDTO){
        return turnoService.modificar(id, turnoDTO);
    }

    @PostMapping
    public TurnoDTO guardar(TurnoDTO turnoDTO){
        return  turnoService.guardarTurno(turnoDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        turnoService.deleteId(id);
    }


}
