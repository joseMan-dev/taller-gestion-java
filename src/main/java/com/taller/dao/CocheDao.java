/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.taller.dao;
import com.taller.model.Coche;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.taller.util.Database;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josemanuelvillaescusalopez
 */
public class CocheDao {
    
    public void insertarCoche(Coche coche) {
        String sql = "INSERT INTO coches (cliente_id, matricula, marca, modelo, anio) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = Database.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, coche.getClienteId());
            stmt.setString(2, coche.getMatricula());
            stmt.setString(3, coche.getMarca());
            stmt.setString(4, coche.getModelo());
            stmt.setInt(5, coche.getAnio());
            
            stmt.executeUpdate();
            
            System.out.println("Coche insertado correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Coche> listarCoches() {
        List<Coche> coches = new ArrayList<>();
        
        String sql = "SELECT c.*, cl.nombre AS cliente_nombre, cl.dni AS cliente_dni  " +
                "FROM coches c " +
                "LEFT JOIN clientes cl ON c.cliente_id = cl.id";
               
                
        
        try (Connection conn = Database.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Coche coche = new Coche(
                    rs.getInt("id"),
                    rs.getInt("cliente_id"),
                    rs.getString("matricula"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getInt("anio")
                            );
                coche.setCliente(rs.getString("cliente_nombre"));
                coche.setDni(rs.getString("cliente_dni"));
                coches.add(coche);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coches;
    }
    
    
    
    public List<Coche> buscarPorCliente(int clienteId) {
         List<Coche> coches = new ArrayList<>();
        
        String sql = "SELECT * FROM coches WHERE cliente_id = ?";
        
        try (Connection conn = Database.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, clienteId);
            
            ResultSet rs = stmt.executeQuery();
        
            
            while (rs.next()) {
                Coche coche = new Coche(
                    rs.getInt("id"),
                    rs.getInt("cliente_id"),
                    rs.getString("matricula"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getInt("anio")
                            );
                coches.add(coche);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coches;
    }
    
    
}
