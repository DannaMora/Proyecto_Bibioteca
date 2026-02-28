package com.curso.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.curso.proyecto.models.LibrosModel;

public interface LibrosRepository extends JpaRepository<LibrosModel, Long>{
    
}