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

import com.curso.proyecto.models.LibrosModel;
import com.curso.proyecto.services.LibrosServices;

@RestController
public class LibrosController {
    @Autowired
    private LibrosServices librosService;

    // Crear libro
    @PostMapping("/api/libro")
    public Integer createLibro(@RequestBody LibrosModel libro) {
        return librosService.createLibro(libro);
    }

    // Obtener todos los libros
    @GetMapping("/api/libro")
    public List<LibrosModel> getAllLibro() {
        return librosService.getLibro();
    }

    // Eliminar un libro
    @DeleteMapping("/api/libro")
    public void deleteLibro(@RequestBody LibrosModel libro) {
        librosService.deleteLibro(libro);
    }

    // Actualizar un libro
    @PutMapping("api/libro")
    public LibrosModel updateLibro(@RequestBody LibrosModel libro) {
        return librosService.updateLibro(libro);
    }

}