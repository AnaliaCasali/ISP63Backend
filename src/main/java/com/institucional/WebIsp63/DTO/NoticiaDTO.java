package com.institucional.WebIsp63.DTO;

import com.institucional.WebIsp63.Entity.Administrador;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class NoticiaDTO {

    long id;
    AdministradorDTO administrador;
    String titulo;
    String subTitulo;

    LocalDate fecha;
    String link;
    String url;
    String texto;

    String imagen;
    boolean becas;}