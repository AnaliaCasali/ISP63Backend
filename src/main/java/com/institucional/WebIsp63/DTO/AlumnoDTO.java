package com.institucional.WebIsp63.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data

public class AlumnoDTO extends PersonaDTO {
    long id;
    String sede;
    String carrera;
    String estado;
    String ingreso;

    public AlumnoDTO(long telefono, String nombre, String apellido, String email, long dni, long password, String sede, String carrera, String estado, String ingreso) {
    }
}
