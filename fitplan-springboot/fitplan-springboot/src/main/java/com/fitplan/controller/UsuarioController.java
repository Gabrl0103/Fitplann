package com.fitplan.controller;

import com.fitplan.model.ObjetivoFisico;
import com.fitplan.model.PerfilFisico;
import com.fitplan.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // POST /api/usuarios/{id}/perfil
    @PostMapping("/{id}/perfil")
    public ResponseEntity<?> guardarPerfil(@PathVariable String id,
                                           @RequestBody Map<String, Object> body) {
        PerfilFisico perfil = usuarioService.guardarPerfil(
            id,
            Double.parseDouble(body.get("peso").toString()),
            Double.parseDouble(body.get("altura").toString()),
            Integer.parseInt(body.get("edad").toString()),
            body.get("genero").toString(),
            ObjetivoFisico.valueOf(body.get("objetivo").toString())
        );
        return ResponseEntity.ok(Map.of(
            "mensaje", "Perfil guardado",
            "imc", perfil.calcularIMC(),
            "clasificacion", perfil.clasificarIMC()
        ));
    }

    // GET /api/usuarios/{id}/perfil
    @GetMapping("/{id}/perfil")
    public ResponseEntity<?> obtenerPerfil(@PathVariable String id) {
        return usuarioService.obtenerPerfil(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
