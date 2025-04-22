package com.example.parcial2.Repository;

import com.example.parcial2.Model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador,Long> {
    // 1. Jugadores de un equipo específico
    @Query(value = "SELECT * FROM jugador WHERE id_equipo = ?1", nativeQuery = true)
    List<Jugador> findJugadoresPorEquipo(Long idEquipo);

    // 2. jugador x goles
    @Query(value = "SELECT j.* FROM jugador j JOIN estadisticas_jugador e ON j.id_jugador = e.id_jugador WHERE e.goles > ?1", nativeQuery = true)
    List<Jugador> findJugadoresConMasDeXGoles(int goles);
}
