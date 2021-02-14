package com.core.federix.repository;

import com.core.federix.models.entities.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository {

    Usuario findByUsuarioLogueo(String usuarioLogueo);
}
