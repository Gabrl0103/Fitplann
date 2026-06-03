package com.fitplan.controller;

import com.fitplan.model.ObjetivoFisico;
import com.fitplan.model.Rutina;
import com.fitplan.service.RutinaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rutinas")
public class RutinaController {

    private final RutinaService rutinaService;

    public RutinaController(RutinaService rutinaService) {
        this.rutinaService = rutinaService;
    }

    // POST /api/rutinas/generar
    @PostMapping("/generar")
    public ResponseEntity<?> generarRutina(@RequestBody Map<String, String> body) {
        Rutina rutina = rutinaService.generarRutina(
            body.get("usuarioId"),
            ObjetivoFisico.valueOf(body.get("objetivo"))
        );
        return ResponseEntity.ok(rutina);
    }

    // GET /api/rutinas/{usuarioId}
    @GetMapping("/{usuarioId}")
    public ResponseEntity<List<Rutina>> obtenerHistorial(@PathVariable String usuarioId) {
        return ResponseEntity.ok(rutinaService.obtenerHistorial(usuarioId));
    }

    // PUT /api/rutinas/{id}/completar
    @PutMapping("/{id}/completar")
    public ResponseEntity<?> marcarCompletada(@PathVariable String id) {
        Rutina rutina = rutinaService.marcarCompletada(id);
        return ResponseEntity.ok(Map.of("mensaje", "Rutina completada", "id", rutina.getId()));
    }
}
