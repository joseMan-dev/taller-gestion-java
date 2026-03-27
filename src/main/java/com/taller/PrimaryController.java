package com.taller;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void abrirClientes() throws IOException {
        App.setRoot("secondary");
    }
}
