package com.example.parcial2.Service;

import com.example.parcial2.Model.Equipo;
import com.example.parcial2.Repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {
    @Autowired
    private EquipoRepository equipoRepository;

    public Equipo guardar(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public List<Equipo> listar() {
        return equipoRepository.findAll();
    }

    public Equipo buscar(long id) {
        if (equipoRepository.existsById(id)) {
            return equipoRepository.getById(id);
        } else {
            throw new RuntimeException("No existe el Equipo con ID " + id);
        }
    }

    public Equipo actualizar(long id, Equipo equipo) {
        if (!equipoRepository.existsById(id)) {
            throw new RuntimeException("No existe el Equipo con ID " + id);
        }
        equipo.setId_equipo(id);
        return equipoRepository.save(equipo);
    }

    public void eliminar(long id) {
        if (!equipoRepository.existsById(id)) {
            throw new RuntimeException("No existe el Equipo con ID " + id);
        }
        equipoRepository.deleteById(id);
    }
}
