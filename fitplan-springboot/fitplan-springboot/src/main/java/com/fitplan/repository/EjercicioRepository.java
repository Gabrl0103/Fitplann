package com.fitplan.repository;

import com.fitplan.model.Ejercicio;
import com.fitplan.model.ObjetivoFisico;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EjercicioRepository extends MongoRepository<Ejercicio, String> {
    List<Ejercicio> findByObjetivo(ObjetivoFisico objetivo);
}
