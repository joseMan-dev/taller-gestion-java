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

public class DbTest {
    public static void main(String[] args) {
        try (Connection con = Database.getConnection()) {
            System.out.println("Conexion OK. BD: " + con.getCatalog());
        } catch (Exception e) {
            System.out.println("Conexión falló");
            e.printStackTrace();
        }
    }
}
