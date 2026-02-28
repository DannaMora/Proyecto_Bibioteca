package com.biblioteca;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginView {

    /*private boolean validarUsuario(String user, String pass) {
        String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
        
        try (java.sql.Connection con = ConexionDBUsuario.obtenerConexion();
             java.sql.PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, user);
            ps.setString(2, pass);
            
            try (java.sql.ResultSet rs = ps.executeQuery()) {
                return rs.next(); 
            }
            
        } catch (java.sql.SQLException e) {
            System.err.println("Error de conexión a la DB: " + e.getMessage());
            return false;
        }
    }*/
   //Prueba temporal de acceso de usuario, se implementara despues con postgresSQL
   private boolean validarUsuario(String user, String pass) {
   
        return ConexionDBUsuario.validarSimulado(user, pass);
    }

    public void mostrar(Stage stage) {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(50));

        Label titulo = new Label("BIBLIOTECA DANNA");
        titulo.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TextField txtUsuario = new TextField();
        txtUsuario.setPromptText("ID");

        PasswordField txtPass = new PasswordField();
        txtPass.setPromptText("Password");

        Button btnEntrar = new Button("Login");
        btnEntrar.setPrefWidth(100);

        btnEntrar.setOnAction(e -> {
            String usuario = txtUsuario.getText().trim();
            String password = txtPass.getText();

            if (usuario.isEmpty() || password.isEmpty()) {
                mostrarAlerta("Campos Requeridos", "Por favor ingresa usuario y contraseña.");
                return;
            }

            if (validarUsuario(usuario, password)) {
                new BibliotecaView().mostrar(stage);
            } else {
                mostrarAlerta("Error de Acceso", "Usuario o contraseña incorrectos.");
            }
        });

        root.getChildren().addAll(titulo, txtUsuario, txtPass, btnEntrar);

        Scene scene = new Scene(root, 500, 600);
        stage.setTitle("Inicio de sesión");
        stage.setScene(scene);
        stage.show();
    }


    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}