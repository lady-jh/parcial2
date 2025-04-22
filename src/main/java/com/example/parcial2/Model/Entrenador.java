package com.example.parcial2.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_entrenador;
    private String nombre;
    private String especialidad;

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    @JsonIgnoreProperties("entrenadores")
    private Equipo equipo;

}
