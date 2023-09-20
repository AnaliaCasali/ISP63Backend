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
    private  String sede;
    @Column (name = "carrera")
    private String carrera;
    private  String estado;
    private String ingreso;


    public Alumno(long telefono, String nombre, String apellido, String email, long dni, long password, String sede, String carrera, String estado, String ingreso) {
        //super(telefono, nombre, apellido, email, dni, password);
        this.sede = sede;
        this.carrera = carrera;
        this.estado = estado;
        this.ingreso = ingreso;

    }
    //public Alumno(long telefono, String nombre, String apellido, String email, long dni, long password, long id, String sede, String carrera, String estado, String ingreso) {

}
