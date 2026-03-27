/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.taller;

import com.taller.dao.RevisionDao;
import com.taller.model.Revision;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author josemanuelvillaescusalopez
 */
public class RevisionTest {
    public static void main (String[] args) {
        RevisionDao revisionDao = new RevisionDao();
        
        //Isertar
        Revision revision = new Revision(
             2,
             LocalDate.of(2026, 3, 17),
             85000,
             "Cambio de aceite y filtros",
             120.50
        );
        
        revisionDao.insertarRevision(revision);
        
        //Listar revisiones
        System.out.println("\n Listado de revisiones:");
        List<Revision> revisiones = revisionDao.listarRevisiones();
        System.out.println("Listado de revisiones:");
        for (Revision r : revisiones) {
            System.out.println(r);
        }
        
        //Buscar revisiones por coche
        System.out.println("\n Revisiones del coche 1:");
        List<Revision> revisionesCoche = revisionDao.buscarPorCocheId(1);
        System.out.println("Revisiones del coche 2:");
        for (Revision r : revisionesCoche) {
            System.out.println(r);
        }
        
        //Buscar por ID
        System.out.println("\n Buscar revisión por ID:");
        Revision r = revisionDao.buscarPorId(2);
        System.out.println(r);
        
        //Actualizar
        if (r!= null) {
            r.setKm(90000);
            r.setObservaciones("Revisión actualizada");
            revisionDao.actualizarRevision(r);
            
            System.out.println("\n Revisión después de actualizar:");
            Revision actualizada = revisionDao.buscarPorId(2);
            System.out.println(actualizada);
        } else {
            
            System.out.println("No existe una revisión con id 1");
        }
        
        //Eliminar(opcional)
        System.out.println("\n Eliminando revisión...");
        revisionDao.eliminarRevision(2);
        
        System.out.println("\n Listado después de eliminar:");
        revisionDao.listarRevisiones().forEach(System.out::println);
    }
    
}
