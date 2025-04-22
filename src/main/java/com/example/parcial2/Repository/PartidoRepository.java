package com.example.parcial2.Repository;

import com.example.parcial2.Model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PartidoRepository extends JpaRepository<Partido,Long> {
    // 4. Resultados de todos los partidos con nombres de equipos
    @Query(value = "SELECT p.id_partido, e1.nombre AS equipo_local, e2.nombre AS equipo_visita, " +
            "p.goles_local, p.goles_visita " +
            "FROM partido p " +
            "INNER JOIN equipo e1 ON p.id_equipo_local = e1.id_equipo " +
            "INNER JOIN equipo e2 ON p.id_equipo_visita = e2.id_equipo",
            nativeQuery = true)
    List<Object[]> obtenerResultadosPartidos();
}
