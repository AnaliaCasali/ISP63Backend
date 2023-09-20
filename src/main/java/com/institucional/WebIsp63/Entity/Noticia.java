package com.institucional.WebIsp63.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;


@Entity
@Table(name="Noticia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name= "subtitulo")
    private String subtitulo;
    @Column(name= "texto")
    private String texto;
    @Column(name= "fechha")
    private String fecha;

    private String imagen;

    private String url;

    private String link;
    @Column(name= "nomcreador")
    private String nomcreador;
    @Column(name= "becas")
    private String becas;
}

