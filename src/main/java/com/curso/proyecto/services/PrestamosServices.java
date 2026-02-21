package com.curso.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.proyecto.models.PrestamosModel;

import com.curso.proyecto.repositories.PrestamosRepository;

@Service
public class PrestamosServices {
    @Autowired
    public PrestamosRepository prestamosRepo;

    public Integer createPrestamos(PrestamosModel prestamos) {
        Integer newId = -1;

        try {
           PrestamosModel pres = prestamosRepo.save(prestamos);
            newId = pres.getId_prestamo();
        }

        catch (Exception e) {
            newId = -2;
        }

        return newId;

    }

    public List<PrestamosModel> getPrestamos() {
        return prestamosRepo.findAll();
    }

    public void deletePrestamos(PrestamosModel prestamos) {
        prestamosRepo.delete(prestamos);
    }

    public PrestamosModel updatePrestamos(PrestamosModel prestamos) {
        return prestamosRepo.save(prestamos);
    }

}
