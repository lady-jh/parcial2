package com.example.parcial2.Model;

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
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_partido;
    private String estadio;
    private LocalDate fecha;
    private int goles_local;
    private int goles_visita;

    @ManyToOne
    @JoinColumn(name = "id_equipo_local")
    @JsonIgnoreProperties({"partidosLocal", "partidosVisita"})
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "id_equipo_visita")
    @JsonIgnoreProperties({"partidosLocal", "partidosVisita"})
    private Equipo equipoVisita;

    @OneToMany(mappedBy = "partido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("partido")
    private List<EstadisticasJugador> estadisticas;

}
