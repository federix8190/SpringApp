package com.core.federix.controllers;

import com.core.federix.models.request.LoginRequest;
import com.core.federix.models.responses.AuthenticationResponse;
import com.core.federix.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtTokenUtil;

    @PostMapping("/signin")
    public ResponseEntity authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        try {
            System.err.println("fede AuthController");
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtTokenUtil.generateJwtToken(authentication);
            return ResponseEntity.ok(new AuthenticationResponse(jwt, 1L));

        } catch (AuthenticationException e) {
            System.err.println("Error en autenticacion : " + e.getMessage());
            return new ResponseEntity(new Error(e), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.err.println("Error generico : " + e.getMessage());
            return new ResponseEntity(new Error(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
