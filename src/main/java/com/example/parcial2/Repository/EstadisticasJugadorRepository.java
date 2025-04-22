package com.example.parcial2.Repository;

import com.example.parcial2.Model.EstadisticasJugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadisticasJugadorRepository extends JpaRepository<EstadisticasJugador,Long> {
    // 3. Total de goles de un equipo en todos sus partidos
    @Query(value = """
        SELECT SUM(ej.goles) FROM estadisticas_jugador ej
        INNER JOIN jugador j ON ej.id_jugador = j.id_jugador
        WHERE j.id_equipo = ?1
        """, nativeQuery = true)
    Integer totalGolesEquipo(Long idEquipo);
}
