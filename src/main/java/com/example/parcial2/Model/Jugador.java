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
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_jugador;
    private String nombre;
    private String posicion;
    private int dorsal;
    private LocalDate fecha_nac;
    private String nacionalidad;

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    @JsonIgnore
    private Equipo equipo;

    @OneToMany(mappedBy = "jugador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<EstadisticasJugador> estadisticas;
}
