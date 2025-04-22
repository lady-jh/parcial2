package com.example.parcial2.Service;

import com.example.parcial2.Model.EstadisticasJugador;
import com.example.parcial2.Repository.EstadisticasJugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadisticasJugadorService {
    @Autowired
    private EstadisticasJugadorRepository estadisticasRepository;


    public EstadisticasJugador guardar(EstadisticasJugador estadistica) {
        return estadisticasRepository.save(estadistica);
    }

    public List<EstadisticasJugador> listar() {
        return estadisticasRepository.findAll();
    }

    public EstadisticasJugador buscar(long id) {
        if (estadisticasRepository.existsById(id)) {
            return estadisticasRepository.getById(id);
        } else {
            throw new RuntimeException("No existe la Estadística con ID " + id);
        }
    }

    public EstadisticasJugador actualizar(long id, EstadisticasJugador estadistica) {
        if (!estadisticasRepository.existsById(id)) {
            throw new RuntimeException("No existe la Estadística con ID " + id);
        }
        estadistica.setId_estadisticasjugador(id);
        return estadisticasRepository.save(estadistica);
    }

    public void eliminar(long id) {
        if (!estadisticasRepository.existsById(id)) {
            throw new RuntimeException("No existe la Estadística con ID " + id);
        }
        estadisticasRepository.deleteById(id);
    }

    public Integer getTotalGolesEquipo(Long idEquipo) {
        return estadisticasRepository.totalGolesEquipo(idEquipo);
    }
}
