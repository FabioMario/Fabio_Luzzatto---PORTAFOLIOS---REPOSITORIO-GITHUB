/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ut1_pd3_fabio;

/**
 *
 * @author fabio
 */
public class Perro implements Mamifero {
    
    private String nombre;
    
    public Perro(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void ladrar(){
        System.out.println("wof");
    }
    public boolean respondeA(String unNombre){
        return this.nombre.equals(unNombre);
    }
    public void caminar(){
        System.out.println("Caminar");
    }
    public void correr(){
        System.out.println("Correr");
    }
    public void saltar(){
        System.out.println("Saltar");
    }
}
