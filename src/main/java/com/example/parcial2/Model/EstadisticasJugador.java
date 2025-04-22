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
public class EstadisticasJugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_estadisticasjugador;
    private int minutos_jugados;
    private int goles;
    private int asistencias;
    private int tarjetas_amarillas;
    private int tarjetas_rojas;

    @ManyToOne
    @JoinColumn(name = "id_jugador")
    @JsonIgnoreProperties({"estadisticas", "equipo"})
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name = "id_partido")
    @JsonIgnoreProperties({"equipoLocal", "equipoVisita"})
    private Partido partido;

}
