package com.fitplan.repository;

import com.fitplan.model.RegistroProgreso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProgressRepository extends MongoRepository<RegistroProgreso, String> {
    List<RegistroProgreso> findByUsuarioIdOrderByFechaAsc(String usuarioId);
}
