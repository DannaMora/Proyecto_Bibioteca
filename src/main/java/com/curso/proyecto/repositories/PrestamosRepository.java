package com.curso.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.curso.proyecto.models.PrestamosModel;

public interface PrestamosRepository extends JpaRepository<PrestamosModel, Integer>{
    
}