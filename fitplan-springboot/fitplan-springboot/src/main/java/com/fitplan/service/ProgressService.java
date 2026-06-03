package com.fitplan.service;

import com.fitplan.model.RegistroProgreso;
import com.fitplan.repository.ProgressRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class ProgressService {

    private final ProgressRepository progressRepository;

    public ProgressService(ProgressRepository progressRepository) {
        this.progressRepository = progressRepository;
    }

    public RegistroProgreso registrarMedicion(String usuarioId, double peso, String notas) {
        RegistroProgreso registro = new RegistroProgreso();
        registro.setUsuarioId(usuarioId);
        registro.setFecha(LocalDate.now());
        registro.setPeso(peso);
        registro.setNotas(notas);
        return progressRepository.save(registro);
    }

    public List<RegistroProgreso> obtenerHistorial(String usuarioId) {
        return progressRepository.findByUsuarioIdOrderByFechaAsc(usuarioId);
    }
}
