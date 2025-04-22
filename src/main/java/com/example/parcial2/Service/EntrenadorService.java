package com.example.parcial2.Service;

import com.example.parcial2.Model.Entrenador;
import com.example.parcial2.Repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorService {
    @Autowired
    private EntrenadorRepository entrenadorRepository;

    public Entrenador guardar(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    public List<Entrenador> listar() {
        return entrenadorRepository.findAll();
    }

    public Entrenador buscar(long id) {
        if (entrenadorRepository.existsById(id)) {
            return entrenadorRepository.getById(id);
        } else {
            throw new RuntimeException("No existe el Entrenador con ID " + id);
        }
    }

    public Entrenador actualizar(long id, Entrenador entrenador) {
        if (!entrenadorRepository.existsById(id)) {
            throw new RuntimeException("No existe el Entrenador con ID " + id);
        }
        entrenador.setId_entrenador(id);
        return entrenadorRepository.save(entrenador);
    }

    public void eliminar(long id) {
        if (!entrenadorRepository.existsById(id)) {
            throw new RuntimeException("No existe el Entrenador con ID " + id);
        }
        entrenadorRepository.deleteById(id);
    }
}
