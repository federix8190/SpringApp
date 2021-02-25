package com.core.federix.services.impl;

import com.core.federix.models.entities.Usuario;
import com.core.federix.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository userRepository;

    @Override
    //@Transactional
    public UserDetails loadUserByUsername(String usuarioLogueo) throws UsernameNotFoundException {

        System.err.println("fede loadUserByUsername : " + usuarioLogueo);
        Optional<Usuario> user = userRepository.findByUsuarioLogueo(usuarioLogueo);
                //.orElseThrow(() -> new UsernameNotFoundException("No se encontró el usuario: " + usuarioLogueo));

        return UserDetailsImpl.build(user.get());
    }
}
