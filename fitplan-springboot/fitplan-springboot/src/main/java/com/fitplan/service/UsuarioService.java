package com.fitplan.service;

import com.fitplan.model.ObjetivoFisico;
import com.fitplan.model.PerfilFisico;
import com.fitplan.repository.PerfilRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioService {

    private final PerfilRepository perfilRepository;

    public UsuarioService(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    public PerfilFisico guardarPerfil(String usuarioId, double peso, double altura,
                                      int edad, String genero, ObjetivoFisico objetivo) {
        PerfilFisico perfil = perfilRepository.findByUsuarioId(usuarioId)
                .orElse(new PerfilFisico());
        perfil.setUsuarioId(usuarioId);
        perfil.setPeso(peso);
        perfil.setAltura(altura);
        perfil.setEdad(edad);
        perfil.setGenero(genero);
        perfil.setObjetivo(objetivo);
        return perfilRepository.save(perfil);
    }

    public Optional<PerfilFisico> obtenerPerfil(String usuarioId) {
        return perfilRepository.findByUsuarioId(usuarioId);
    }
}
