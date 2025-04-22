package com.example.parcial2.Repository;

import com.example.parcial2.Model.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrenadorRepository extends JpaRepository<Entrenador,Long> {
}
