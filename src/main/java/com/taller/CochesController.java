/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.taller;
import com.taller.model.Cliente;
import com.taller.dao.ClienteDao;
import com.taller.dao.CocheDao;
import com.taller.model.Coche;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;

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
    
    @FXML
    private TableColumn<Coche, String> colCliente;
    
    @FXML
    private TableColumn<Coche, String> colDni;
    
    @FXML private TextField txtMatricula;
    
    @FXML private TextField txtMarca;
    
    @FXML private TextField txtModelo;
    
    @FXML private TextField txtAnio;
    
    @FXML private ComboBox<Cliente> comboClientes;
    
    @FXML
    private void volverAClientes() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/taller/secondary.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) tablaCoches.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Gestión de Clientes");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void cargarClientes() {
        ClienteDao dao = new ClienteDao();
        comboClientes.getItems().setAll(dao.obtenerTodos());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colAnio.setCellValueFactory(new PropertyValueFactory<>("anio"));
        colCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        
        cargarCoches();
        cargarClientes();
    }
    
    private void cargarCoches() {
        CocheDao dao = new CocheDao();
        List<Coche> lista = dao.listarCoches();
        
        ObservableList<Coche> datos = FXCollections.observableArrayList(lista);
        tablaCoches.setItems(datos);
    }
    @FXML
    private void guardarCoche() {
        try {
            Cliente cliente = comboClientes.getValue();
            
            if (cliente == null) {
                System.out.println("Seleccionar un cliente");
                return;
            }
            
            Coche coche = new Coche(
                cliente.getId(),
                txtMatricula.getText(),
                txtMarca.getText(),
                txtModelo.getText(),
                Integer.parseInt(txtAnio.getText())
            );
            
            CocheDao dao = new CocheDao();
            dao.insertarCoche(coche);
            
            cargarCoches();
            
            txtMatricula.clear();
            txtMarca.clear();
            txtModelo.clear();
            txtAnio.clear();
            comboClientes.setValue(null);
            
            System.out.println("Coche guardado correctamente");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
