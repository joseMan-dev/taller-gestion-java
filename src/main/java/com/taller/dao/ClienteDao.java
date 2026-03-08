/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.taller.dao;

import com.taller.model.Cliente;
import com.taller.util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josemanuelvillaescusalopez
 */
public class ClienteDao {
    
    
     public void insertarCliente(Cliente cliente) {
            
            String sql = "INSERT INTO clientes (dni, nombre, telefono, email) VALUES (?, ?, ?, ?)";
            try (Connection conn = Database.getConnection();
                    PreparedStatement stmt = conn.prepareStatement(sql)) {
                
                stmt.setString(1, cliente.getDni());
                stmt.setString(2, cliente.getNombre());
                stmt.setString(3, cliente.getTelefono());
                stmt.setString(4, cliente.getEmail());
                
                stmt.executeUpdate();
                
                System.out.println("Cliente insertado correctamente");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
    public List<Cliente> obtenerTodos() {
        
       
        
        List<Cliente> clientes = new ArrayList<>();
        
        String sql = "SELECT * FROM clientes";
        
        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                
                Cliente cliente = new Cliente();
                
                cliente.setId(rs.getInt("id"));
                cliente.setDni(rs.getString("dni"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEmail(rs.getString("email"));
                
                clientes.add(cliente);
            }
        } catch (Exception e) {
                e.printStackTrace();
                }
        
             return clientes;
             
        
            }
    public void actualizarCliente(Cliente cliente) {
        String sql = "UPDATE clientes SET nombre=?, telefono=?, email=? WHERE dni=?";
        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getTelefono());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getDni());
            
            stmt.executeUpdate();
            
            System.out.println("Cliente actualizado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void eliminarCliente(String dni) {
        String sql = "DELETE FROM clientes WHERE dni=?";
        
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
             stmt.setString(1, dni);
             stmt.executeUpdate();
             
             System.out.println("Cliente eliminado correctamente ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Cliente buscarPorDni(String dni) {
        String sql = "SELECT * FROM clientes WHERE dni=?";
        
        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, dni);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                
                Cliente cliente = new Cliente();
                
                cliente.setId(rs.getInt("id"));
                cliente.setDni(rs.getString("dni"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEmail(rs.getString("email"));
                
                return cliente;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
        }
        
       

