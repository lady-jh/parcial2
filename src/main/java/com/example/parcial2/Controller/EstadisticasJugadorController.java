package com.example.parcial2.Controller;

import com.example.parcial2.Model.Equipo;
import com.example.parcial2.Model.EstadisticasJugador;
import com.example.parcial2.Service.EstadisticasJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estadisticas")
public class EstadisticasJugadorController {
    @Autowired
    private EstadisticasJugadorService estadisticasJugadorService;

    @GetMapping("/listar")
    public ResponseEntity<List<EstadisticasJugador>> listar() {
        return ResponseEntity.ok(estadisticasJugadorService.listar());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(estadisticasJugadorService.buscar(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> guardar(@RequestBody EstadisticasJugador estadisticasJugador) {
        EstadisticasJugador nuevo = estadisticasJugadorService.guardar(estadisticasJugador);
        return ResponseEntity.status(HttpStatus.CREATED).body("Estadisticas Jugador guardado con ID " + nuevo.getId_estadisticasjugador());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody EstadisticasJugador estadisticasJugador) {
        try {
            EstadisticasJugador actualizado = estadisticasJugadorService.actualizar(id, estadisticasJugador);
            return ResponseEntity.ok("EstadisticasJugador actualizado con ID " + actualizado.getId_estadisticasjugador());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        try {
            estadisticasJugadorService.eliminar(id);
            return ResponseEntity.ok("Estadisticas Jugador eliminado con ID " + id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }

    // consulta nativa
    @GetMapping("/totalgoles/{idEquipo}")
    public ResponseEntity<?> totalGolesEquipo(@PathVariable Long idEquipo) {
        Integer total = estadisticasJugadorService.getTotalGolesEquipo(idEquipo);
        return ResponseEntity.ok("Total de goles del equipo: " + total);
    }

}
