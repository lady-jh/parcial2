package com.example.parcial2.Service;

import com.example.parcial2.Model.Jugador;
import com.example.parcial2.Repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorService {
    @Autowired
    private JugadorRepository jugadorRepository;

    public Jugador guardar(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public List<Jugador> listar() {
        return jugadorRepository.findAll();
    }

    public Jugador buscar(long id) {
        if (jugadorRepository.existsById(id)) {
            return jugadorRepository.getById(id);
        } else {
            throw new RuntimeException("No existe el Jugador con ID " + id);
        }
    }

    public Jugador actualizar(long id, Jugador jugador) {
        if (!jugadorRepository.existsById(id)) {
            throw new RuntimeException("No existe el Jugador con ID " + id);
        }
        jugador.setId_jugador(id);
        return jugadorRepository.save(jugador);
    }

    public void eliminar(long id) {
        if (!jugadorRepository.existsById(id)) {
            throw new RuntimeException("No existe el Jugador con ID " + id);
        }
        jugadorRepository.deleteById(id);
    }

    public List<Jugador> getJugadoresPorEquipo(Long idEquipo) {
        return jugadorRepository.findJugadoresPorEquipo(idEquipo);
    }


    public List<Jugador> getJugadoresConMasDeXGoles(int goles) {
        return jugadorRepository.findJugadoresConMasDeXGoles(goles);
    }


}
