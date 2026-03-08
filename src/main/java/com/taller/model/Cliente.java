/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.taller.model;

/**
 *
 * @author josemanuelvillaescusalopez
 */
public class Cliente {
    
    private int id;
    private String dni;
    private String nombre;
    private String telefono;
    private String email;
    
    public Cliente() {
        
    }
    
    public Cliente(int id, String dni, String nombre, String telefono, String email) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }
    
    public int getId() { return id; }
    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
    
    public void setId(int id) {this.id = id; }
    public void setDni ( String dni ) {this.dni = dni; }
    public void setNombre( String nombre ) { this.nombre = nombre; }
    public void setTelefono( String telefono) { this.telefono = telefono; }
    public void setEmail( String email ) { this.email = email; }
    
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre= " + nombre + '\'' +
                ", telefono= " + telefono + '\'' +
                ", email=' " + email + '\'' +
                '}';
    }
}
    

