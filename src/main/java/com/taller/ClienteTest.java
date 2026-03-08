/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.taller;

import com.taller.dao.ClienteDao;
import com.taller.model.Cliente;

import java.util.List;

/**
 *
 * @author josemanuelvillaescusalopez
 */
public class ClienteTest {
    
    public static void main(String[] args) {
        
        ClienteDao dao = new ClienteDao();
        
        
        
        Cliente nuevo = new Cliente(0, "12345678A",  "Carlos", "666123123", "carlos@email.com");
        dao.insertarCliente(nuevo);
        
        nuevo.setNombre("Carlos modificado");
        nuevo.setTelefono("999999999");
        
        dao.actualizarCliente(nuevo);
        
        //Buscar cliente por DNI
        Cliente encontrado = dao.buscarPorDni("12345678A");
        
        if (encontrado != null) {
            System.out.println("Cliente encontrado: ");
            System.out.println(
                     encontrado.getId() + " - " +
                     encontrado.getDni() + " - " +
                     encontrado.getNombre() + " - " +
                     encontrado.getTelefono() + " - " +
                     encontrado.getEmail()
            );
        } else {
            System.out.println("Cliente no encontrado");
        }
        dao.eliminarCliente("12345678A");
        
        List<Cliente> clientes = dao.obtenerTodos();
        
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes en la base de datos");
           
        } else {
            for (Cliente c : clientes) {
                System.out.println(
                c.getId() + " - " +
                c.getDni() + " - " +
                c.getNombre() + " - " +
                c.getTelefono() + " - " +
                c.getEmail()
                );
            }
        }
    }
    
}
