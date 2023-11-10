package com.institucional.WebIsp63.DTO;

import com.institucional.WebIsp63.Entity.Carrera;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data

public class AlumnoDTO extends PersonaDTO {
    long id;
    CarreraDTO carrera;
    boolean estado;

    public AlumnoDTO(long telefono, String nombre,
                     String apellido, String email, long dni, String password,  Carrera carrera) {
    }
}
