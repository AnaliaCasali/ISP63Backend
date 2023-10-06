package com.institucional.WebIsp63.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name = "carrera")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "sede")
    private String sede;

    private int numeroPlan;
    @Column(name ="campoOcupacional")
    private String campoOcupacional;

    private String horario;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "imagen_id", nullable = false)//
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @NonNull
    @Builder.Default
    private Imagen imagen=new Imagen();


}
