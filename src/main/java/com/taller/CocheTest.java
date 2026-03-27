/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.taller;
import com.taller.dao.CocheDao;
import com.taller.model.Coche;
import java.util.List;

/**
 *
 * @author josemanuelvillaescusalopez
 */
public class CocheTest {
    
    public static void main(String[] args) {
        
        
        CocheDao cocheDao = new CocheDao();
        
        // 1. INSERTAR COCHE
        Coche coche = new Coche(
        0,
        10,
        "7777AAA",
        "Audi",
        "A3",2021
        );
        cocheDao.insertarCoche(coche);
        
        // 2. Consultar
        List<Coche> coches = cocheDao.buscarPorCliente(10);
        
        System.out.println("Coches del cliente 10:");
        
        for (Coche c : coches) {
            System.out.println(c);
        }
    }
    
}
