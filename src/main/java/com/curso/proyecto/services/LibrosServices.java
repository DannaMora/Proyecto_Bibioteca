package com.curso.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.proyecto.models.LibrosModel;
import com.curso.proyecto.repositories.LibrosRepository;

@Service
public class LibrosServices {
    @Autowired
    public LibrosRepository libroRepo;

    public Integer createLibro(LibrosModel libro) {
        Integer newIsbn = -1;

        try {
            LibrosModel lib = libroRepo.save(libro);
            newIsbn = lib.getIsbn();
        }

        catch (Exception e) {
            newIsbn = -2;
        }

        return newIsbn;

    }

    public List<LibrosModel> getLibro() {
        return libroRepo.findAll();
    }

    public void deleteLibro(LibrosModel libro) {
        libroRepo.delete(libro);
    }

    public LibrosModel updateLibro(LibrosModel libro) {
        return libroRepo.save(libro);
    }

}
