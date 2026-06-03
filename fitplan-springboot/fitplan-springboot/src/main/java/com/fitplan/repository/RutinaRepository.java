package com.fitplan.repository;

import com.fitplan.model.Rutina;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RutinaRepository extends MongoRepository<Rutina, String> {
    List<Rutina> findByUsuarioId(String usuarioId);
    long countByUsuarioIdAndCompletada(String usuarioId, boolean completada);
}
