package com.institucional.WebIsp63.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Persona{
    @Id
    @GeneratedValue
    private Long id;
    @Column (name = "telefono")
    private  long telefono;
    private  String nombre;
    private String apellido;
    private  String email;
    private long dni;
    private long password;
}
