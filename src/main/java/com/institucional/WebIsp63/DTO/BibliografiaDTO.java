package com.institucional.WebIsp63.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter
public class BibliografiaDTO {
    long id;

    String titulo;

    String descripcion;
    TemaDTO tema;
    String namecreador;

}
