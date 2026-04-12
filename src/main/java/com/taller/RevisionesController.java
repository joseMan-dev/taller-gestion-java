/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.taller;

import com.taller.dao.CocheDao;
import com.taller.dao.RevisionDao;
import com.taller.model.Coche;
import com.taller.model.Revision;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 *
 * @author josemanuelvillaescusalopez
 */
public class RevisionesController implements Initializable {
    
    @FXML
    private ComboBox<Coche> comboCoches;
    
    @FXML
    private TextField txtFecha;
    
    @FXML
    private TextField txtKm;
    
    @FXML
    private TableView<Revision> tablaRevisiones;
    
    @FXML
    private TableColumn<Revision, Integer> colId;
    
    @FXML
    private TableColumn<Revision, String> colCoche;
    
    @FXML
    private TableColumn<Revision, String> colFecha;
    
    @FXML
    private TableColumn<Revision, Integer> colKm;
    
    
    
    private final RevisionDao revisionDao = new RevisionDao();
    private final CocheDao cocheDao = new CocheDao();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCoche.setCellValueFactory(new PropertyValueFactory<>("cocheInfo"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colKm.setCellValueFactory(new PropertyValueFactory<>("km"));
        
        
        cargarCoches();
        cargarRevisiones();
    }
    
    private void cargarCoches() {
        List<Coche> coches = cocheDao.listarCoches();
        comboCoches.getItems().addAll(coches);
    }
    
    private void cargarRevisiones() {
        List<Revision> revisiones = revisionDao.listarRevisiones();
        System.out.println("Revisiones cargadas: " + revisiones.size());
        
        tablaRevisiones.getItems().setAll(revisiones);
    }
    
    @FXML
    private void guardarRevision() {
       try {
           Coche cocheSeleccionado = comboCoches.getValue();
           
           if (cocheSeleccionado == null) {
               System.out.println("Debes seleccionar un coche");
               return;
           }
           
           LocalDate fecha = LocalDate.parse(txtFecha.getText());
           int km = Integer.parseInt(txtKm.getText());
           
           Revision revision = new Revision();
           revision.setCocheId(cocheSeleccionado.getId());
           revision.setFecha(fecha);
           revision.setKm(km);
           revision.setObservaciones("");
           revision.setCosteTotal(0.0);
           
           revisionDao.insertarRevision(revision);
           
           cargarRevisiones();
           
           comboCoches.setValue(null);
           txtFecha.clear();
           txtKm.clear();
           
           System.out.println("Revisión guardada correctamente");
           
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
    
    @FXML
    private void volverAClientes() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/taller/secondary.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) tablaRevisiones.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Gestión de Clientes");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
