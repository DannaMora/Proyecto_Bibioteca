package com.biblioteca;

import java.sql.Connection;
import java.sql.SQLException;

/*public class ConexionDBUsuario {
    private static final String URL = "jdbc:postgresql://localhost:5432/usuario";
    private static final String USER = "postgres";
    private static final String PASS = "tu_password";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}*/


//PRUEBA TEMPORAL, SE QUITARA CUANDO LA DB ESTE LISTA   

public class ConexionDBUsuario {
    
    // Simulamos la validación sin necesidad de PostgreSQL
    public static boolean validarSimulado(String user, String pass) {
        // AQUÍ DEFINES TU USUARIO DE PRUEBA
        String usuarioCorrecto = "admin";
        String passwordCorrecto = "1234";

        return user.equals(usuarioCorrecto) && pass.equals(passwordCorrecto);
    }

    // Dejamos este método vacío por ahora para que no de error el código, 
    // pero no lo usaremos mientras simulemos.
    public static Connection obtenerConexion() throws SQLException {
        return null; 
    }
}