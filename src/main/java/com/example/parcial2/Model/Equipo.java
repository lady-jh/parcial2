package com.example.parcial2.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_equipo;
    private String nombre;
    private String ciudad;
    private LocalDate fundacion;

    @OneToMany(mappedBy = "equipoLocal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Partido> partidosLocal;

    @OneToMany(mappedBy = "equipoVisita", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Partido> partidosVisita;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Jugador> jugadores;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("equipo")
    private List<Entrenador> entrenadores;

}
