package com.curso.proyecto.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.proyecto.models.UsuariosModel;
import com.curso.proyecto.services.UsuariosServices;

@RestController
public class UsuariosController {
    @Autowired
    private UsuariosServices usuariosService;

    // Crear Usuario
    @PostMapping("/api/usuario")
    public Integer createUsuario(@RequestBody UsuariosModel usuario) {
        return usuariosService.createUsuario(usuario);
    }

    // Obtener todos los usuarios
    @GetMapping("/api/usuario")
    public List<UsuariosModel> getAllUsuario() {
        return usuariosService.getUsuario();
    }

    // Eliminar un usuario
    @DeleteMapping("/api/usuario")
    public void deleteUsuario(@RequestBody UsuariosModel usuario) {
        usuariosService.deleteUsuario(usuario);
    }

    // Actualizar un usuario
    @PutMapping("api/usuario")
    public UsuariosModel updateUsuario(@RequestBody UsuariosModel usuario) {
        return usuariosService.updateUsuario(usuario);
    }

}

