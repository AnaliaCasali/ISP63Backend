package com.institucional.WebIsp63.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "inscripcion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "fecha")
    private LocalDate fecha;
   // private Alumno alumno;
    @ManyToOne
    @JoinColumn(name = "mesaExamen_id")
    private MesaExamen mesaExamen;

}
