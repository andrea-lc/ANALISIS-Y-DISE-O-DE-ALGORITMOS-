/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author admin
 */
public class Gatos {
    // ========================
    // ATRIBUTOS
    // ========================
    public int id;
    // Nombre del gato
    private String nombre;
    // Edad del gato en años
    private int edad;
    // Raza del gato (ejemplo: Persa, Siamés, Mestizo)
    private String raza;
    // Estado en el qe se encuentra el gato (En adopción, Adoptado, En cuidado, En recuperación)
    private String estado_gato;
    // Cuidados que necesita el gato por si requiere alguna atencion medica
    private String cuidado_requerido;

    // ========================
    // CONSTRUCTOR
    // ========================
    // Constructor paramétrico que recibe todos los datos del gato.
    // Permite crear un objeto Gatos con valores específicos desde el inicio.
    public Gatos(int id, String nombre, int edad, String raza, String estado_gato, String cuidado_requerido) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.estado_gato= estado_gato;
        this.cuidado_requerido= cuidado_requerido;                
    }

    // ========================
    // MÉTODOS GETTERS
    // ========================
    // Devuelve el ID del gato
    public int getId() {
        return id;
    }

    // Devuelve el nombre del gato
    public String getNombre() {
        return nombre;
    }

    // Devuelve la edad del gato
    public int getEdad() {
        return edad;
    }

    // Devuelve la raza del gato
    public String getRaza() {
        return raza;
    }

    public String getEstado_gato() {
        return estado_gato;
    }

    public String getCuidado_requerido() {
        return cuidado_requerido;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setEstado_gato(String estado_gato) {
        this.estado_gato = estado_gato;
    }

    public void setCuidado_requerido(String cuidado_requerido) {
        this.cuidado_requerido = cuidado_requerido;
    }

    
    // ========================
    // MÉTODO toString()
    // ========================
    // Sobrescribe el método toString de la clase Object.
    // Permite mostrar la información del gato en formato legible al imprimir el objeto.
    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad + ", Raza: " + raza + 
                ", Estado: "+ estado_gato + ", Cuidado requeridos: "+ cuidado_requerido;
    }
}