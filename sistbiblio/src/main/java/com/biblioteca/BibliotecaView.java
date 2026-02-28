package com.biblioteca;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BibliotecaView {

    private TableView<Libro> tabla = new TableView<>();
    private ObservableList<Libro> datosLibros = FXCollections.observableArrayList();

    public void mostrar(Stage stage) {
        BorderPane root = new BorderPane();

        // --- 1. BARRA SUPERIOR (Búsqueda y Usuario) ---
        HBox topBar = new HBox(15);
        topBar.setPadding(new Insets(15));
        topBar.setStyle("-fx-background-color: #2c3e50;");

        TextField txtBusqueda = new TextField();
        txtBusqueda.setPromptText("Buscar por título, autor o editorial...");
        txtBusqueda.setPrefWidth(400);

        Label lblUsuario = new Label("Bibliotecario: Admin");
        lblUsuario.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button btnSalir = new Button("Cerrar Sesión");
        btnSalir.setOnAction(e -> new LoginView().mostrar(stage));

        topBar.getChildren().addAll(txtBusqueda, spacer, lblUsuario, btnSalir);

        // --- 2. BARRA LATERAL (Navegación) ---
        VBox sideBar = new VBox(10);
        sideBar.setPadding(new Insets(20));
        sideBar.setPrefWidth(150);
        sideBar.setStyle("-fx-background-color: #ecf0f1;");

        Button btnLibros = new Button("📚 Libros");
        Button btnPrestamos = new Button("🤝 Préstamos");
        Button btnUsuarios = new Button("👥 Usuarios");
        
        // Estilo para que ocupen todo el ancho
        btnLibros.setMaxWidth(Double.MAX_VALUE);
        btnPrestamos.setMaxWidth(Double.MAX_VALUE);
        btnUsuarios.setMaxWidth(Double.MAX_VALUE);

        sideBar.getChildren().addAll(new Label("MENÚ"), btnLibros, btnPrestamos, btnUsuarios);

        // --- 3. CONFIGURACIÓN DE LA TABLA (Vista Default) ---
        configurarTablaLibros();
        cargarDatosEjemplo();

        // --- 4. LÓGICA DE BÚSQUEDA FILTRADA ---
        FilteredList<Libro> filteredData = new FilteredList<>(datosLibros, p -> true);
        txtBusqueda.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(libro -> {
                if (newValue == null || newValue.isEmpty()) return true;
                String lowerCaseFilter = newValue.toLowerCase();

                if (libro.getTitulo().toLowerCase().contains(lowerCaseFilter)) return true;
                if (libro.getAutor().toLowerCase().contains(lowerCaseFilter)) return true;
                return false; // No hubo coincidencia
            });
        });
        tabla.setItems(filteredData);

        // Organizar el layout
        root.setTop(topBar);
        root.setLeft(sideBar);
        root.setCenter(new VBox(10, new Label("Listado General"), tabla));
        VBox.setVgrow(tabla, Priority.ALWAYS);

        Scene scene = new Scene(root, 1000, 600);
        stage.setTitle("Sistema de Gestión de Biblioteca");
        stage.setScene(scene);
    }

    private void configurarTablaLibros() {
        TableColumn<Libro, String> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Libro, String> colTitulo = new TableColumn<>("Título");
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));

        TableColumn<Libro, String> colAutor = new TableColumn<>("Autor");
        colAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));

        tabla.getColumns().addAll(colId, colTitulo, colAutor);
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    private void cargarDatosEjemplo() {
        datosLibros.add(new Libro("1", "Cien años de soledad", "Gabriel García Márquez"));
        datosLibros.add(new Libro("2", "Don Quijote de la Mancha", "Miguel de Cervantes"));
        datosLibros.add(new Libro("3", "El resplandor", "Stephen King"));
    }
}