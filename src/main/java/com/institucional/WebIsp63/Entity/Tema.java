package com.institucional.WebIsp63.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Temas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String tema;

}
