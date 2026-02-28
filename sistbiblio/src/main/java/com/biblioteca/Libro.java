package com.biblioteca;

import javafx.beans.property.SimpleStringProperty;

public class Libro {
    private final SimpleStringProperty id;
    private final SimpleStringProperty titulo;
    private final SimpleStringProperty autor;

    public Libro(String id, String titulo, String autor) {
        this.id = new SimpleStringProperty(id);
        this.titulo = new SimpleStringProperty(titulo);
        this.autor = new SimpleStringProperty(autor);
    }

    public String getId() { return id.get(); }
    public String getTitulo() { return titulo.get(); }
    public String getAutor() { return autor.get(); }
}