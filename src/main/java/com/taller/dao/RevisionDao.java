/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.taller.dao;
import com.taller.model.Revision;
import com.taller.util.Database;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josemanuelvillaescusalopez
 */
public class RevisionDao {
    
    public void insertarRevision(Revision revision) {
        String sql = "INSERT INTO revisiones (coche_id, fecha, km, observaciones, coste_total) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = Database.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, revision.getCocheId());
            stmt.setDate(2, Date.valueOf(revision.getFecha()));
            stmt.setInt(3, revision.getKm());
            stmt.setString(4, revision.getObservaciones());
            stmt.setDouble(5, revision.getCosteTotal());
            
            stmt.executeUpdate();
            System.out.println("Revisión insertada con éxito");
            
        } catch (SQLException e) {
            System.out.println("Error al insertar revisión: " + e.getMessage());
        }
        
    }   
    
    public List<Revision> listarRevisiones() {
        List<Revision> revisiones = new ArrayList<>();
        String sql = "SELECT * FROM revisiones";
        
        try (Connection conn = Database.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery()) {
            
        while (rs.next()) {
            Revision revision = new Revision(
            rs.getInt("id"),
            rs.getInt("coche_id"),
            rs.getDate("fecha").toLocalDate(),
            rs.getInt("km"),
            rs.getString("observaciones"),
            rs.getDouble("coste_total")
            );
            
            revisiones.add(revision);
        }
        } catch (SQLException e) {
            System.out.println("Error al listar revisiones: " + e.getMessage());
        }
        return revisiones;
    }
    
    public List<Revision> buscarPorCocheId(int cocheId) {
        List<Revision> revisiones = new ArrayList<>();
        String sql = "SELECT * FROM revisiones WHERE coche_id = ?";
        
        try (Connection conn = Database.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, cocheId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Revision revision = new Revision(
                         rs.getInt("id"),
                         rs.getInt("coche_id"),
                         rs.getDate("fecha").toLocalDate(),
                         rs.getInt("km"),
                         rs.getString("observaciones"),
                         rs.getDouble("coste_total")
                    );
                    
                    revisiones.add(revision);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar revisiones por coche: " + e.getMessage());
        }
        return revisiones;
    }
    
    public Revision buscarPorId(int id) {
        String sql = "SELECT * FROM revisiones WHERE id = ?";
        Revision revision = null;
        
        try (Connection conn = Database.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    revision = new Revision(
                    rs.getInt("id"),
                    rs.getInt("coche_id"),
                    rs.getDate("fecha").toLocalDate(),
                    rs.getInt("km"),
                    rs.getString("observaciones"),
                    rs.getDouble("coste_total")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar revisión por id: " + e.getMessage());
        }
        return revision;
    }
    
    public void actualizarRevision(Revision revision) {
        String sql = "UPDATE revisiones SET coche_id = ?, fecha = ?, km = ?, observaciones = ?, coste_total = ? WHERE id = ?";
        
        try (Connection conn = Database.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, revision.getCocheId());
            stmt.setDate(2, Date.valueOf(revision.getFecha()));
            stmt.setInt(3, revision.getKm());
            stmt.setString(4, revision.getObservaciones());
            stmt.setDouble(5, revision.getCosteTotal());
            stmt.setInt(6, revision.getId());
            
            int filas = stmt.executeUpdate();
            
            if (filas > 0) {
                System.out.println("Revisión actualizada con éxito");
            } else {
                System.out.println("No se encontró ninguna revisión con ese id");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar revisión: " + e.getMessage());
        }
    
    }
    
    public void eliminarRevision(int id) {
        String sql = "DELETE FROM revisiones WHERE id = ?";
        
        try (Connection conn = Database.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            
            int filas = stmt.executeUpdate();
            
            if (filas > 0) {
                System.out.println("Revisión eliminada con éxito");
            } else {
                System.out.println("No se encontró ninguna revisión con ese id");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar revisión: " + e.getMessage());
        }
    }
    
    
    
}
