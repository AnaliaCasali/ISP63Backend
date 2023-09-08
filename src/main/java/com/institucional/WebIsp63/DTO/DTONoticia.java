package com.institucional.WebIsp63.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.*;

@Data
@AllArgsConstructor
public class DTONoticia {

    long id;
    String subTitulo;

    String texto;

    String fecha;


    String url;

    String link;

    String NomCreador;
    String becas;
}
