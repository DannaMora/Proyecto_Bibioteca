module com.biblioteca {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.biblioteca to javafx.graphics, javafx.fxml;
}