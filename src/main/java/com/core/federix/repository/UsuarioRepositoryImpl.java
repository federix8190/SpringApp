package com.core.federix.repository;

import com.core.federix.models.entities.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @Override
    public Usuario findByUsuarioLogueo(String usuarioLogueo) {

        System.err.println("fede findByUsuarioLogueo");
        if (usuarioLogueo.equals("federix@test.com")) {
            return new Usuario(1, "Fede Torres", usuarioLogueo, "testing");
        } else if (usuarioLogueo.equals("jperez@test.com")) {
            return new Usuario(2, "Juan Perez", usuarioLogueo, "cambiar123");
        } else {
            return null;
        }
    }
}
