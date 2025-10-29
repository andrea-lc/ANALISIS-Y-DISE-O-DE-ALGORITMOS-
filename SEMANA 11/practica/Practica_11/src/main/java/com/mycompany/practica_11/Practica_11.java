/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author admin
 */
public class Practica_11 {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Carlos",20));
        personas.add(new Persona("Ana", 34));
        personas.add(new Persona("Pedro", 23));
        
        System.out.println("LISTA ORIGINAL");
        System.out.println(personas);
        Collections.sort(personas); // Orden natural por nombre
        System.out.println("LISTA ORDENADA");
        System.out.println(personas);
        }    
}

