/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.taller.model;
import java.time.LocalDate;

/**
 *
 * @author josemanuelvillaescusalopez
 */
public class Revision {
    
    private int id;
    private int cocheId;
    private LocalDate fecha;
    private int km;
    private String observaciones;
    private double costeTotal;
    
    public Revision() {
        
    }
    
    public Revision(int cocheId, LocalDate fecha, int km, String observaciones, double costeTotal) {
        this.cocheId = cocheId;
        this.fecha = fecha;
        this.km = km;
        this.observaciones = observaciones;
        this.costeTotal = costeTotal;
    }
    
    public Revision(int id, int cocheId, LocalDate fecha, int km, String observaciones, double costeTotal) {
        this.id = id;
        this.cocheId = cocheId;
        this.fecha = fecha;
        this.km = km;
        this.observaciones = observaciones;
        this.costeTotal = costeTotal;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getCocheId() {
        return cocheId;
    }
    
    public void setCocheId(int cocheId) {
        this.cocheId = cocheId;
    }
    
    public LocalDate getFecha() {
        return fecha;
    }
    
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    public int getKm() {
        return km;
    }
    
    public void setKm(int km) {
        this.km = km;
    } 
    
    public String getObservaciones() {
        return observaciones;
    }
            
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    public double getCosteTotal() {
        return costeTotal;
    }
    
    public void setCosteTotal(double costeTotal) {
        this.costeTotal = costeTotal;
    }
    
    @Override
    public String toString() {
        return "Revision{" +
                "id= " + id +
                ", cocheId=" + cocheId +
                ", fecha=" + fecha +
                ", km=" + km +
                ", observaciones=" + observaciones + '\'' +
                ", costeTotal=" + costeTotal +
                '}';
    }
}
