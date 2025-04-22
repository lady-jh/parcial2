package com.example.parcial2.Service;

import com.example.parcial2.Model.Partido;
import com.example.parcial2.Repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PartidoService {
    @Autowired
    private PartidoRepository partidoRepository;

    public Partido guardar(Partido partido) {
        return partidoRepository.save(partido);
    }

    public List<Partido> listar() {
        return partidoRepository.findAll();
    }

    public Partido buscar(long id) {
        if (partidoRepository.existsById(id)) {
            return partidoRepository.getById(id);
        } else {
            throw new RuntimeException("No existe el Partido con ID " + id);
        }
    }

    public Partido actualizar(long id, Partido partido) {
        if (!partidoRepository.existsById(id)) {
            throw new RuntimeException("No existe el Partido con ID " + id);
        }
        partido.setId_partido(id);
        return partidoRepository.save(partido);
    }

    public void eliminar(long id) {
        if (!partidoRepository.existsById(id)) {
            throw new RuntimeException("No existe el Partido con ID " + id);
        }
        partidoRepository.deleteById(id);
    }

    public List<Map<String, Object>> getResultadosPartidos() {
        List<Object[]> resultados = partidoRepository.obtenerResultadosPartidos();
        List<Map<String, Object>> listaMapeada = new ArrayList<>();

        for (Object[] fila : resultados) {
            Map<String, Object> map = new HashMap<>();
            map.put("id_partido", fila[0]);
            map.put("equipo_local", fila[1]);
            map.put("equipo_visita", fila[2]);
            map.put("goles_local", fila[3]);
            map.put("goles_visita", fila[4]);
            listaMapeada.add(map);
        }

        return listaMapeada;
    }


}
