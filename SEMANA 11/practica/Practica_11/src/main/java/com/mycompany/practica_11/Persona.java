/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica_11;

/**
 *
 * @author admin
 */
public class Persona implements Comparable<Persona>{
    String nombre;
    int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    } 
    @Override
    public String toString() {
        return "Nombre: "+ nombre + ", Edad: " + edad;
    }     

    @Override
    public int compareTo(Persona otra) {
        return this.nombre.compareTo(otra.nombre);    
    }
}
