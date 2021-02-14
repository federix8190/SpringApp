package com.core.federix.repository;

import com.core.federix.models.entities.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioRepositoryImpl implements UsuarioRepository {
    @Override
    public Usuario findByUsuarioLogueo(String usuarioLogueo) {
        return new Usuario(1, "Fede Torres", "federix@test.com");
    }
}
