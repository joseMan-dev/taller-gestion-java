/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.taller.util;

/**
 *
 * @author josemanuelvillaescusalopez
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Database {
    
    private static final String URL = "jdbc:mysql://localhost:3306/taller_coches?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Europe/Madrid";
    
    private static final String USER = "root";
    
    private static final String PASS = "Tigreton85";
    
    private Database() {}
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
