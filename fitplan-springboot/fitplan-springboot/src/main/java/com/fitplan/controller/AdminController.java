package com.fitplan.controller;

import com.fitplan.model.Usuario;
import com.fitplan.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // GET /api/admin/usuarios
    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(adminService.listarUsuarios());
    }

    // PUT /api/admin/usuarios/{id}/activar
    @PutMapping("/usuarios/{id}/activar")
    public ResponseEntity<?> activar(@PathVariable String id) {
        adminService.activarUsuario(id);
        return ResponseEntity.ok(Map.of("mensaje", "Usuario activado"));
    }

    // PUT /api/admin/usuarios/{id}/desactivar
    @PutMapping("/usuarios/{id}/desactivar")
    public ResponseEntity<?> desactivar(@PathVariable String id) {
        adminService.desactivarUsuario(id);
        return ResponseEntity.ok(Map.of("mensaje", "Usuario desactivado"));
    }
}
