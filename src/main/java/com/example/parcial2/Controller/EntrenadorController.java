package com.example.parcial2.Controller;

import com.example.parcial2.Model.Entrenador;
import com.example.parcial2.Service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenador")
public class EntrenadorController {
    @Autowired
    private EntrenadorService entrenadorService;

    @GetMapping("/listar")
    public ResponseEntity<List<Entrenador>> listar() {
        return ResponseEntity.ok(entrenadorService.listar());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(entrenadorService.buscar(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> guardar(@RequestBody Entrenador entrenador) {
        Entrenador nuevo = entrenadorService.guardar(entrenador);
        return ResponseEntity.status(HttpStatus.CREATED).body("Entrenador guardado con ID " + nuevo.getId_entrenador());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Entrenador entrenador) {
        try {
            Entrenador actualizado = entrenadorService.actualizar(id, entrenador);
            return ResponseEntity.ok("Entrenador actualizado con ID " + actualizado.getId_entrenador());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        try {
            entrenadorService.eliminar(id);
            return ResponseEntity.ok("Entrenador eliminado con ID " + id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }
}

