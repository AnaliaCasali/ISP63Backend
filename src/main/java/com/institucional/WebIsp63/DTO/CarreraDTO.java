package com.institucional.WebIsp63.DTO;


import lombok.*;


@Data
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder

public class CarreraDTO {

    private long id;
    private String nombre;
    private String sede;
    private int numeroPlan;
    private String campoOcupacional;
    private String horario;
    private ImagenDTO imagen;

}
