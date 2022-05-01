/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ut1_pd3_fabio;

/**
 *
 * @author fabio
 */
public class Gato implements Mamifero {
    
    private String nombre;
    
    public Gato(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void maullar(){
        System.out.println("miau");
    }
    public boolean respondeA(String unNombre){
        return this.nombre.equals(unNombre);
    }
    public void caminar(){
        System.out.println("Caminar");
    }
    public void correr(){
        System.out.println("Corriendo");
    }
    public void saltar(){
        System.out.println("Saltando");
    }
}
