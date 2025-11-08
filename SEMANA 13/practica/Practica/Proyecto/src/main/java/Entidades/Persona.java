package Entidades;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class Persona{
    protected int dni_persona;
    protected String nombre; 
    protected int telefono;
    protected String direccion;
    protected String correo;
    protected String contraseña;

    // Constructor original
    public Persona(String contraseña, int dni_persona, String nombre, int telefono, String direccion, String correo) {
        this.contraseña= contraseña;
        this.dni_persona = dni_persona;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }

    // Constructor de copia
    public Persona(Persona otraPersona) {
        this.contraseña= otraPersona.contraseña;
        this.dni_persona = otraPersona.dni_persona;
        this.nombre = otraPersona.nombre;
        this.telefono = otraPersona.telefono;
        this.direccion = otraPersona.direccion;
        this.correo = otraPersona.correo;
    }
    

    // Metodos que puede ser sobrescrito
    public String getInformacionCompleta() {
        return String.format("ID: %d, Nombre: %s, Tel: %d, Dirección: %s, Email: %s", 
                           dni_persona, nombre, telefono, direccion, correo);
    }


    public String getContraseña() { return contraseña; }
    public void setConstraseña(String contraseña) { this.contraseña = contraseña; }
    public int getId_persona() { return dni_persona; }
    public void setId_persona(int dni_persona) { this.dni_persona = dni_persona; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getTelefono() { return telefono; }
    public void setTelefono(int telefono) { this.telefono = telefono; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
}