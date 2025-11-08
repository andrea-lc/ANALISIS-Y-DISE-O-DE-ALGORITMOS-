/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestores;

import Entidades.Adoptantes;
import Entidades.Persona;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author admin
 */
public class Gestor_Adoptante extends GestorBase<Adoptantes>{

    public Gestor_Adoptante() {
        super("Adoptantes.txt");
    }
    Gestor_usuarios gestor= new Gestor_usuarios();


    
    @Override
    public void cargarDatos() {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 8) { 
                    String nombre= datos[2];
                    String fecha_adopciones= datos[6];
                    String observaciones=datos [7];
                    String correo= datos[5];
                    
                    Persona persona= gestor.buscar(correo);
                    
                    getElementos().put(nombre, new Adoptantes(persona,fecha_adopciones,observaciones));
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar usuarios (puede que el archivo esté vacio).");
        }
    }

    @Override
    public void guardarCambios() {
    }

    @Override
    public boolean registrar(Adoptantes elemento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean existe(String identificador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificar(String datoModificar, int opcion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Adoptantes> ordenar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Adoptantes buscar(String identificador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}   
