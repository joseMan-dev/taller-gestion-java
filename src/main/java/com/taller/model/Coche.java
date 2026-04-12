/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.taller.model;

/**
 *
 * @author josemanuelvillaescusalopez
 */
public class Coche {
    
    private int id;
    private String cliente;
    private String dni;
    private int clienteId;
    private String matricula;
    private String marca;
    private String modelo;
    private int anio;
    


//Construcuto vacío
public Coche() {

}

//Constructor sin id
public Coche(int clienteId, String matricula, String marca, String modelo, int anio) {
    this.clienteId = clienteId;
    this.matricula = matricula;
    this.marca = marca;
    this.modelo = modelo;
    this.anio = anio;
}

//Constructor con Id
public Coche (int id, int clienteId, String matricula, String marca, String modelo, int anio) {
     this.id = id;
     this.clienteId = clienteId;
     this.matricula = matricula;
     this.marca = marca;
     this.modelo = modelo;
     this.anio = anio;
}

public int getId() {
     return id;
}

public void setId(int id) {
     this.id = id;
}

public int getClienteId() {
      return clienteId;
}

public void setClienteId(int clienteId) {
      this.clienteId = clienteId;
}

public String getMatricula() {
       return matricula;
}

public void setMatricula(String matricula) {
       this.matricula = matricula;
}

public String getMarca() {
       return marca;
}

public void setMarca(String marca) {
       this.marca = marca;
}

public String getModelo() {
       return modelo;
}

public void setModelo(String modelo) {
       this.modelo = modelo;
}

public int getAnio() {
       return anio;
}

public void setAnio(int anio) {
       this.anio = anio;
}

public String getCliente() {
    return cliente;
}

public void setCliente(String cliente) {
    this.cliente = cliente;
}

public String getDni() {
    return dni;
}

public void setDni(String dni) {
    this.dni = dni;
}

@Override
public String toString() {
    return matricula + " - " + marca + " - " + modelo;
}
}