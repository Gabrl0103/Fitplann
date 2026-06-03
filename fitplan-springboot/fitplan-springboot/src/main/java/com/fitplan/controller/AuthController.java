package com.fitplan.controller;

import com.fitplan.model.Usuario;
import com.fitplan.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // POST /api/auth/login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String correo = body.get("correo");
        String contrasena = body.get("contrasena");
        Optional<Usuario> usuario = authService.login(correo, contrasena);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(Map.of(
                "mensaje", "Login exitoso",
                "id", usuario.get().getId(),
                "nombre", usuario.get().getNombre(),
                "rol", usuario.get().getRol()
            ));
        }
        return ResponseEntity.status(401).body(Map.of("error", "Credenciales incorrectas"));
    }

    // POST /api/auth/registro
    @PostMapping("/registro")
    public ResponseEntity<?> registro(@RequestBody Map<String, String> body) {
        try {
            Usuario usuario = authService.registrar(
                body.get("nombre"),
                body.get("correo"),
                body.get("contrasena")
            );
            return ResponseEntity.ok(Map.of(
                "mensaje", "Usuario registrado correctamente",
                "id", usuario.getId(),
                "nombre", usuario.getNombre()
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}
