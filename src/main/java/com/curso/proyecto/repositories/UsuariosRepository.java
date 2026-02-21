package com.curso.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.curso.proyecto.models.UsuariosModel;

public interface UsuariosRepository extends JpaRepository<UsuariosModel, Integer>{
    
}
