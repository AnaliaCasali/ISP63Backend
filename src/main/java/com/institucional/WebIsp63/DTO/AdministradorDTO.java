package com.institucional.WebIsp63.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data

public class AdministradorDTO  extends PersonaDTO{
    String cargo;

    public AdministradorDTO(String cargo, String apellido, String nombre, String email, long dni, long password) {
    }
}
