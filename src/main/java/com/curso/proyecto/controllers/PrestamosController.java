package com.curso.proyecto.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.proyecto.models.PrestamosModel;
import com.curso.proyecto.services.PrestamosServices;

@RestController
public class PrestamosController {
    @Autowired
    private PrestamosServices prestamosService;

    // Crear prestamos
    @PostMapping("/api/prestamos")
    public Integer createPrestamos(@RequestBody PrestamosModel prestamos) {
        return prestamosService.createPrestamos(prestamos);
    }

    // Obtener todos los prestamos
    @GetMapping("/api/prestamos")
    public List<PrestamosModel> getAllPrestamos() {
        return prestamosService.getPrestamos();
    }

    // Eliminar un prestamos
    @DeleteMapping("/api/prestamos")
    public void deletePrestamos(@RequestBody PrestamosModel prestamos) {
        prestamosService.deletePrestamos(prestamos);
    }

    // Actualizar un prestamos
    @PutMapping("api/prestamos")
    public PrestamosModel updatePrestamos(@RequestBody PrestamosModel prestamos) {
        return prestamosService.updatePrestamos(prestamos);
    }

}