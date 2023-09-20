package com.institucional.WebIsp63.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Bibliografia")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Bibliografia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;

    @Column(name= "titulo")
    private String titulo;
    @Column(name= "descripcion")
    private String descripcion;

    @ManyToOne( cascade = CascadeType.MERGE)
    @JoinColumn(name="Tema_Id", nullable = false)
    private Tema tema;
    @Column(name= "namecreador")
    private String namecreador;
}
