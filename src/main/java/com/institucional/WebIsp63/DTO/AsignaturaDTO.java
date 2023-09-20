package com.institucional.WebIsp63.DTO;

import com.institucional.WebIsp63.Entity.Carrera;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

@AllArgsConstructor
public class AsignaturaDTO {
    long id;
    String asignatura;
    String tipo;
    Carrera carrera;
    int anio;
    int cargaHorario;
    int duracion;
    String correlativaRendir;
    String correlativaCursar;
}
