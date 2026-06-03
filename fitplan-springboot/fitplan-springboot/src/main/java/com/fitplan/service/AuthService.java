package com.fitplan.service;

import com.fitplan.config.PasswordUtil;
import com.fitplan.model.Usuario;
import com.fitplan.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;

    public AuthService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<Usuario> login(String correo, String contrasena) {
        Optional<Usuario> usuario = usuarioRepository.findByCorreo(correo);
        if (usuario.isPresent() && usuario.get().isActivo()) {
            if (PasswordUtil.verificar(contrasena, usuario.get().getContrasena())) {
                return usuario;
            }
        }
        return Optional.empty();
    }

    public Usuario registrar(String nombre, String correo, String contrasena) {
        if (usuarioRepository.existsByCorreo(correo)) {
            throw new RuntimeException("El correo ya está registrado.");
        }
        Usuario usuario = new Usuario(nombre, correo,
                PasswordUtil.hashPassword(contrasena), "usuario");
        return usuarioRepository.save(usuario);
    }
}
