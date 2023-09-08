package com.institucional.WebIsp63.DTO;

import com.institucional.WebIsp63.Entity.Asignatura;
import com.institucional.WebIsp63.Entity.Turno;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;
@Data
@AllArgsConstructor
public class MesaExamenDTO {

    long id;
    LocalDate fecha;
    Turno turno;
    Asignatura asignatura;
    int horario;
    long tribunal;
}

