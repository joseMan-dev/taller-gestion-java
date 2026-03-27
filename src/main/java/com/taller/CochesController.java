/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.taller;
import com.taller.dao.CocheDao;
import com.taller.model.Coche;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


/**
 *
 * @author josemanuelvillaescusalopez
 */
public class CochesController implements Initializable {
    
    @FXML
    private TableView<Coche> tablaCoches;
    
    @FXML
    private TableColumn<Coche, String> colMatricula;
    
    @FXML
    private TableColumn<Coche, String> colMarca;
    
    @FXML
    private TableColumn<Coche, String> colModelo;
    
    @FXML
    private TableColumn<Coche, Integer> colAnio;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colAnio.setCellValueFactory(new PropertyValueFactory<>("anio"));
        
        cargarCoches();
    }
    
    private void cargarCoches() {
        CocheDao dao = new CocheDao();
        List<Coche> lista = dao.listarCoches();
        
        ObservableList<Coche> datos = FXCollections.observableArrayList(lista);
        tablaCoches.setItems(datos);
    }
    
    
}
