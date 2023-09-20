package com.institucional.WebIsp63.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "asignatura")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "asignatura")
    private String asignatura;
    @Column(name = "tipo")
    private String tipo;

    @Column(name = "año")
    private int anio;
    @Column(name = "cargaHorario")
    private int cargaHorario;
    private int duracion;
    @Column(name = "correlativaRendir")
    private String correlativaRendir;
    @Column(name = "correlativaCursar")
    private String correlativaCursar;
    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

}
