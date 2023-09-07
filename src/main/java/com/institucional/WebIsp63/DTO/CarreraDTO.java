package com.institucional.WebIsp63.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor
public class CarreraDTO {

    long id;
    String nombre;
    String sede;
    int numeroPlan;
    String campoOcupacional;

    String horario;
}
