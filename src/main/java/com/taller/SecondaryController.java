package com.taller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import com.taller.dao.ClienteDao;
import com.taller.model.Cliente;
import com.taller.model.Coche;
import com.taller.dao.CocheDao;


public class SecondaryController implements Initializable {

    @FXML
    private TextField dniField;
    
    @FXML
    private TextField nombreField;
    
    @FXML
    private TextField telefonoField;
    
    @FXML
    private TextField emailField;
    
    @FXML
    private TableView<Cliente> tablaClientes;
    
    @FXML 
    private TableColumn<Cliente, String> colDni;
    
    @FXML 
    private TableColumn<Cliente, String> colNombre;
    
    @FXML
    private TableColumn<Cliente, String> colTelefono;
    
    @FXML
    private TableColumn<Cliente, String> colEmail;
    
    @FXML
    private void eliminarClienteSeleccionado() {
        Cliente clienteSeleccionado = tablaClientes.getSelectionModel().getSelectedItem();
        
        if (clienteSeleccionado == null) {
            System.out.println("Slecciona un cliente primero");
            return;
        }
        
        ClienteDao clienteDao = new ClienteDao();
        clienteDao.eliminarCliente(clienteSeleccionado.getDni());
        cargarClientes();
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        
        
        cargarClientes();
    }
    
    @FXML
    private void guardarCliente() {
        String dni = dniField.getText();
        String nombre = nombreField.getText();
        String telefono = telefonoField.getText();
        String email = emailField.getText();
        
        Cliente cliente = new Cliente();
        cliente.setDni(dni);
        cliente.setNombre(nombre);
        cliente.setTelefono(telefono);
        cliente.setEmail(email);
        
        ClienteDao dao = new ClienteDao();
        dao.insertarCliente(cliente);
        
        limpiarCampos();
        cargarClientes();
    }
    
    private void cargarClientes() {
        ClienteDao dao = new ClienteDao();
        List<Cliente> lista = dao.obtenerClientes();
        tablaClientes.getItems().setAll(lista);
    }
    
    private void limpiarCampos() {
        dniField.clear();
        nombreField.clear();
        telefonoField.clear();
        emailField.clear();
    }
    
    @FXML
    private void volverInicio(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/taller/primary.fxml"));
        Stage stage = (Stage) dniField.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    @FXML
    private void irACoches(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/taller/coches.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    @FXML
    private void abrirRevisiones() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/taller/revisiones.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) tablaClientes.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Gestión de revisiones");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
   
    
  
            
            
    
    
    
}