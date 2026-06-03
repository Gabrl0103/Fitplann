package com.fitplan.controller;

import com.fitplan.model.PerfilFisico;
import com.fitplan.service.NutricionService;
import com.fitplan.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/nutricion")
public class NutricionController {

    private final NutricionService nutricionService;
    private final UsuarioService usuarioService;

    public NutricionController(NutricionService nutricionService, UsuarioService usuarioService) {
        this.nutricionService = nutricionService;
        this.usuarioService = usuarioService;
    }

    // GET /api/nutricion/{usuarioId}
    @GetMapping("/{usuarioId}")
    public ResponseEntity<?> calcularRecomendacion(@PathVariable String usuarioId) {
        return usuarioService.obtenerPerfil(usuarioId)
            .map(perfil -> ResponseEntity.ok(nutricionService.calcularRecomendacion(perfil)))
            .orElse(ResponseEntity.notFound().build());
    }
}
