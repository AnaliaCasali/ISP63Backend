package com.institucional.WebIsp63.Entity;

import com.institucional.WebIsp63.DTO.AdministradorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;
import java.time.LocalDate;


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
    @ManyToOne(cascade= CascadeType.PERSIST)
    @JoinColumn(name="administrador_id")
    private Administrador administrador;
    private String titulo;
    private String subTitulo;
    private LocalDate fecha;
    private String texto;
    private String imagen;
    private String link;
    private String url;

    private boolean beca;


}