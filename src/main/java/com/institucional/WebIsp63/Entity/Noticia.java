package com.institucional.WebIsp63.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;


@Entity
@Table(name="Noticias")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String subTitulo;

    private String texto;

    private String fecha;

    private String imagen;

    private String url;

    private String link;

    private String nomCreador;

    private String becas;
}

