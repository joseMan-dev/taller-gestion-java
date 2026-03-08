module com.taller {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.taller to javafx.fxml;
    exports com.taller;
}
