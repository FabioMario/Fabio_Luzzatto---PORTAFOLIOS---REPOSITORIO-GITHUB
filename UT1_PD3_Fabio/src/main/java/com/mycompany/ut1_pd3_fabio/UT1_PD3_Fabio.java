/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.ut1_pd3_fabio;

/**
 *
 * @author fabio
 */
public class UT1_PD3_Fabio {

    public static void main(String[] args) {
        Perro perro = new Perro("Keks");
        Gato gato = new Gato("Manchita");
        perro.respondeA("Buenas Tardes");
        gato.caminar();
        perro.saltar();
        gato.maullar();
    }
}
