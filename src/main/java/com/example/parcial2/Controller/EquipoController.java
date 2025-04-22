package com.example.parcial2.Controller;

import com.example.parcial2.Model.Equipo;
import com.example.parcial2.Service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipo")
public class EquipoController {
    @Autowired
    private EquipoService equipoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Equipo>> listar() {
        return ResponseEntity.ok(equipoService.listar());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(equipoService.buscar(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> guardar(@RequestBody Equipo equipo) {
        Equipo nuevo = equipoService.guardar(equipo);
        return ResponseEntity.status(HttpStatus.CREATED).body("Equipo guardado con ID " + nuevo.getId_equipo());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Equipo equipo) {
        try {
            Equipo actualizado = equipoService.actualizar(id, equipo);
            return ResponseEntity.ok("Equipo actualizado con ID " + actualizado.getId_equipo());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        try {
            equipoService.eliminar(id);
            return ResponseEntity.ok("Equipo eliminado con ID " + id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }
}
