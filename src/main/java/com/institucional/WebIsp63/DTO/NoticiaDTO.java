package com.institucional.WebIsp63.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NoticiaDTO {

    long id;
    String subTitulo;

    String texto;

    String fecha;


    String url;

    String link;

    String NomCreador;
    String becas;
}
