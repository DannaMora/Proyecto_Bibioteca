package com.curso.proyecto.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Prestamos")
@Data
public class PrestamosModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_prestamo")
    private Integer id_prestamo;

    @Column(name = "id_usuario")
    private Integer id_usuario;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "nombre_usuario_snapshot")
    private String nombre_usuario_snapshot;

    @Column(name = "titulo_libro_snapshot")
    private String titulo_libro_snapshot;

    @Column(name = "fecha_salida")
    private String fecha_salida;

    @Column(name = "fecha_entrega_esperada")
    private String fecha_entrega_esperada;

    @Column(name = "fecha_entrega_real")
    private String fecha_entrega_real;

    @Column(name = "estatus")
    private String estatus;


}