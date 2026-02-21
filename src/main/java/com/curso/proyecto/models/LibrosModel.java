package com.curso.proyecto.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Libros")
@Data
public class LibrosModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "isbn")
    private String isbn;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "autores")
    private String autores;

    @Column(name = "editorial")
    private String editorial;

    @Column(name = "anio_publicacion")
    private String anio_publicacion;

    @Column(name = "categoria_genero")
    private String categoria_genero;

    @Column(name = "copias_totales")
    private String copias_totales;
    
    @Column(name = "copias_prestadas")
    private String copias_prestadas;

    @Column(name = "copias_disponibles", insertable = false, updatable = false)
    private Integer copias_disponibles;

    @Column(name = "ubicacion_biblioteca")
    private String ubicacion_biblioteca;

    @Column(name = "prestamos_2020")
    private String prestamos_2020;

    @Column(name = "prestamos_2021")
    private String prestamos_2021;

    @Column(name = "prestamos_2022")
    private String prestamos_2022;

    @Column(name = "prestamos_2023")
    private String prestamos_2023;

    @Column(name = "prestamos_2024")
    private String prestamos_2024;

    @Column(name = "prestamos_2025")
    private String prestamos_2025;


}
