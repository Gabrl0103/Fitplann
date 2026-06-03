package com.fitplan.service;

import com.fitplan.model.Usuario;
import com.fitplan.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminService {

    private final UsuarioRepository usuarioRepository;

    public AdminService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario activarUsuario(String id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setActivo(true);
        return usuarioRepository.save(usuario);
    }

    public Usuario desactivarUsuario(String id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setActivo(false);
        return usuarioRepository.save(usuario);
    }
}
