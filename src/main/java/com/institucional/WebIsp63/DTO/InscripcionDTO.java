package com.institucional.WebIsp63.DTO;

import com.institucional.WebIsp63.Entity.MesaExamen;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class InscripcionDTO {
    long id;
    LocalDate fecha;
    //Alumno alumno;
    MesaExamen mesaExamen;
}
