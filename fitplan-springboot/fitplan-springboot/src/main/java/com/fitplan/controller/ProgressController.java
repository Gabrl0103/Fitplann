package com.fitplan.controller;

import com.fitplan.model.RegistroProgreso;
import com.fitplan.service.ProgressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/progreso")
public class ProgressController {

    private final ProgressService progressService;

    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }

    // POST /api/progreso
    @PostMapping
    public ResponseEntity<?> registrarMedicion(@RequestBody Map<String, Object> body) {
        RegistroProgreso registro = progressService.registrarMedicion(
            body.get("usuarioId").toString(),
            Double.parseDouble(body.get("peso").toString()),
            body.get("notas").toString()
        );
        return ResponseEntity.ok(registro);
    }

    // GET /api/progreso/{usuarioId}
    @GetMapping("/{usuarioId}")
    public ResponseEntity<List<RegistroProgreso>> obtenerHistorial(@PathVariable String usuarioId) {
        return ResponseEntity.ok(progressService.obtenerHistorial(usuarioId));
    }
}
