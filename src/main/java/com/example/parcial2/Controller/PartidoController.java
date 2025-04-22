package com.example.parcial2.Controller;

import com.example.parcial2.Model.Partido;
import com.example.parcial2.Service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partido")
public class PartidoController {
    @Autowired
    public PartidoService partidoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Partido>> listar() {
        List<Partido> partidos = partidoService.listar();
        return ResponseEntity.ok(partidos);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable long id) {
        try {
            Partido partido = partidoService.buscar(id);
            return ResponseEntity.ok(partido);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> guardar(@RequestBody Partido partido) {
        Partido nuevoPartido = partidoService.guardar(partido);
        return ResponseEntity.status(HttpStatus.CREATED).body("Partido guardado exitosamente con ID " + nuevoPartido.getId_partido());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable long id, @RequestBody Partido partido) {
        try {
            Partido partidoActualizado = partidoService.actualizar(id, partido);
            return ResponseEntity.ok("Partido actualizado correctamente con ID " + partidoActualizado.getId_partido());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable long id) {
        try {
            partidoService.eliminar(id);
            return ResponseEntity.ok("El partido con ID " + id + " fue eliminado correctamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }

// consulta nativa
    @GetMapping("/resultados")
    public ResponseEntity<?> resultadosPartidos() {
        return ResponseEntity.ok(partidoService.getResultadosPartidos());
    }

}
