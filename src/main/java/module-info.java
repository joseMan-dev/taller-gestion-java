module com.taller {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.taller to javafx.fxml;
    opens com.taller.model to javafx.base;
    exports com.taller;
    exports com.taller.model;
}
