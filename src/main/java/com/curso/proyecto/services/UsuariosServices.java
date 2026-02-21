package com.curso.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.proyecto.models.UsuariosModel;
import com.curso.proyecto.repositories.UsuariosRepository;

@Service
public class UsuariosServices {
    @Autowired
    public UsuariosRepository usuarioRepo;

    public Integer createUsuario(UsuariosModel usuario) {
        Integer newId = -1;

        try {
            UsuariosModel usu = usuarioRepo.save(usuario);
            newId = usu.getId_usuario();
        }

        catch (Exception e) {
            newId = -2;
        }

        return newId;

    }

    public List<UsuariosModel> getUsuario() {
        return usuarioRepo.findAll();
    }

    public void deleteUsuario(UsuariosModel usuario) {
        usuarioRepo.delete(usuario);
    }

    public UsuariosModel updateUsuario(UsuariosModel usuario) {
        return usuarioRepo.save(usuario);
    }

}
