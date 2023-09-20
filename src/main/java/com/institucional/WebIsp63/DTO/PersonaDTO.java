package com.institucional.WebIsp63.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class PersonaDTO  {
     long telefono;
     String nombre;
     String apellido;
     String email;
     long dni;
     long password;
}

