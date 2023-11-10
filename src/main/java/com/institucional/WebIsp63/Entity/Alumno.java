package com.institucional.WebIsp63.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table (name="Alumno")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Alumno extends Persona {
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;*/

    @ManyToOne ( cascade = CascadeType.PERSIST)
    @JoinColumn(name="Carrera_id")
    private Carrera carrera;

    private boolean estado=false;
    public Alumno(long telefono, String nombre, String apellido, String email, long dni, String password,  Carrera carrera) {

        this.carrera = carrera;



    }

}
