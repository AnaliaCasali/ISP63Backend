package com.institucional.WebIsp63.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.lang.model.element.Name;
import java.time.LocalDate;

@Entity
@Table(name = "mesaExamen")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MesaExamen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    @Column(name = "fecha")
    private LocalDate fecha;
    @Column(name = "turno")
    private String turno;


    @Column(name = "horario")
    private  int horario;

    private  long tribunal;

    @ManyToOne
    @JoinColumn(name = "asignatura_id")
    private Asignatura asignatura;
}
