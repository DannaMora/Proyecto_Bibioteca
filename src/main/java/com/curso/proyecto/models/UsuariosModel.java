package com.curso.proyecto.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class UsuariosModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private Integer id_usuario;

    @Column(name = "password")
    private String password;

    @Column(name = "nombre_completo")
    private String nombre_completo;

    @Column(name = "correo_electronico")
    private String correo_electronico;

    @Column(name = "tipo_usuario")
    private String tipo_usuario;

    @Column(name = "fecha_registro")
    private String fecha_registro;

    @Column(name = "estado")
    private String estado;

}
