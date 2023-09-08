package com.institucional.WebIsp63.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TurnoDTO {
    long id;
    String turno;
}
