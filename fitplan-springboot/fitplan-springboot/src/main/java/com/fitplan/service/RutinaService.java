package com.fitplan.service;

import com.fitplan.model.Ejercicio;
import com.fitplan.model.ObjetivoFisico;
import com.fitplan.model.Rutina;
import com.fitplan.repository.EjercicioRepository;
import com.fitplan.repository.RutinaRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RutinaService {

    private static final int MAX_EJERCICIOS = 6;

    private final RutinaRepository rutinaRepository;
    private final EjercicioRepository ejercicioRepository;

    public RutinaService(RutinaRepository rutinaRepository,
                         EjercicioRepository ejercicioRepository) {
        this.rutinaRepository = rutinaRepository;
        this.ejercicioRepository = ejercicioRepository;
    }

    public Rutina generarRutina(String usuarioId, ObjetivoFisico objetivo) {
        List<Ejercicio> disponibles = ejercicioRepository.findByObjetivo(objetivo);
        Collections.shuffle(disponibles);
        List<Ejercicio> seleccionados = disponibles.subList(
                0, Math.min(MAX_EJERCICIOS, disponibles.size()));

        Rutina rutina = new Rutina();
        rutina.setUsuarioId(usuarioId);
        rutina.setNombre("Rutina " + objetivo.getDescripcion() + " - " + LocalDate.now());
        rutina.setObjetivo(objetivo);
        rutina.setFechaCreacion(LocalDate.now());
        rutina.setCompletada(false);
        rutina.setEjercicioIds(seleccionados.stream()
                .map(Ejercicio::getId).collect(Collectors.toList()));
        return rutinaRepository.save(rutina);
    }

    public List<Rutina> obtenerHistorial(String usuarioId) {
        return rutinaRepository.findByUsuarioId(usuarioId);
    }

    public Rutina marcarCompletada(String rutinaId) {
        Rutina rutina = rutinaRepository.findById(rutinaId)
                .orElseThrow(() -> new RuntimeException("Rutina no encontrada"));
        rutina.setCompletada(true);
        return rutinaRepository.save(rutina);
    }

    public long obtenerTotalCompletadas(String usuarioId) {
        return rutinaRepository.countByUsuarioIdAndCompletada(usuarioId, true);
    }
}
