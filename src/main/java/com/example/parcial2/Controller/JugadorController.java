package com.example.parcial2.Controller;

import com.example.parcial2.Model.Jugador;
import com.example.parcial2.Service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugador")
public class JugadorController {
    @Autowired
    private JugadorService jugadorService;

    @GetMapping("/listar")
    public ResponseEntity<List<Jugador>> listar() {
        return ResponseEntity.ok(jugadorService.listar());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(jugadorService.buscar(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> guardar(@RequestBody Jugador jugador) {
        Jugador nuevo = jugadorService.guardar(jugador);
        return ResponseEntity.status(HttpStatus.CREATED).body("Jugador guardado con ID " + nuevo.getId_jugador());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Jugador jugador) {
        try {
            Jugador actualizado = jugadorService.actualizar(id, jugador);
            return ResponseEntity.ok("Jugador actualizado con ID " + actualizado.getId_jugador());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        try {
            jugadorService.eliminar(id);
            return ResponseEntity.ok("Jugador eliminado con ID " + id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }

    // consulta nativa
    @GetMapping("/equipo/{id}")
    public ResponseEntity<List<Jugador>> jugadoresPorEquipo(@PathVariable Long id) {
        return ResponseEntity.ok(jugadorService.getJugadoresPorEquipo(id));
    }

    @GetMapping("/goles/{minGoles}")
    public ResponseEntity<List<Jugador>> jugadoresConMasGoles(@PathVariable int minGoles) {
        return ResponseEntity.ok(jugadorService.getJugadoresConMasDeXGoles(minGoles));
    }


}

