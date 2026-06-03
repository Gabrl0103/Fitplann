package com.fitplan.repository;

import com.fitplan.model.PerfilFisico;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PerfilRepository extends MongoRepository<PerfilFisico, String> {
    Optional<PerfilFisico> findByUsuarioId(String usuarioId);
}
