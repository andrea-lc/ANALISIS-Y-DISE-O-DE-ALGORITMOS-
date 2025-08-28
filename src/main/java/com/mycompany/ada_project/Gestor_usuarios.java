/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ada_project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
class Gestor_usuarios {
    // ========================
    // ATRIBUTOS
    // ========================
    // Atributo estático y constante (final): su valor no cambia durante la ejecución
    // Representa la ruta del archivo donde se guardan los usuarios
    private static final String Ruta_archivo = "usuarios.txt";
    
    // Lo mismo pero aca se guardaran los gatos
    private static final String Ruta_gatos = "gatos.txt";

    // ========================
    // MÉTODOS
    // ========================

    // Método público, paramétrico, sin retorno (void).
    // Recibe usuario y contraseña como parámetros y los guarda en el archivo usuarios.txt
    public void registrar_usuario(String usuario, String contraseña) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Ruta_archivo, true))) {
            bw.write(usuario + "," + contraseña); // Guardar en formato CSV
            bw.newLine();
            System.out.println("Usuario agregado correctamente.");
        } catch (IOException ex) {
            System.out.println("Error al leer usuarios.txt");
        }      
    }
    
    // Método público, paramétrico, con retorno (boolean).
    // Recibe usuario y contraseña como parámetros.
    // Retorna true si las credenciales existen en el archivo usuarios.txt, de lo contrario false.
    public boolean login(String usuario, String contraseña) {
        try (BufferedReader br = new BufferedReader(new FileReader(Ruta_archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 2) {
                    String validarUsuario = datos[0];
                    String validarContra = datos[1];
                    if (validarUsuario.equals(usuario) && validarContra.equals(contraseña)) {
                        return true; // Credenciales correctas
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Error leyendo archivo de usuarios.");
        }
        return false; // Si no encuentra coincidencia
    }
       
    // Método público, paramétrico, sin retorno (void).
    // Recibe datos de un gato (id, nombre, edad y raza) y los guarda en el archivo gatos.txt
    public void guardarGato(int iD, String nombre, int edad, String raza) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Ruta_gatos, true))) {
            bw.write(iD + "," + nombre + ","+ edad + ","+ raza);
            bw.newLine();
            System.out.println("Gato agregado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar gato en el archivo.");
        }
    }

    /**
     * Método público y no paramétrico.
     * Retorna: List<Gatos> → una lista con todos los gatos leídos desde el archivo.
     * Función:
     *   - Lee el archivo "gatos.txt".
     *   - Convierte cada línea en un objeto Gatos.
     *   - Ordena la lista por el ID de los gatos usando inserción.
     */
    public List<Gatos> leerGatos() {
        List<Gatos> listaGatos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(Ruta_gatos))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4) {
                    int id = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    int edad = Integer.parseInt(datos[2]);
                    String raza = datos[3];
                    listaGatos.add(new Gatos(id, nombre, edad, raza)); // Crea y agrega un objeto Gatos.
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer gatos desde el archivo.");
        }

        /** Ordena la lista de gatos por ID usando algoritmo de Inserción
        *   - Complejidad (Big-O):
        *   - Lectura del archivo: O(n), siendo n el número de gatos.
        *   - Ordenamiento por inserción:
        *   - Mejor caso (lista ya ordenada): O(n).
        *   - Peor caso (lista en orden descendente): O(n^2).
        *   - Complejidad total (dominante): O(n^2).
        */
        for (int i = 1; i < listaGatos.size(); i++) {                       // n                       
            Gatos actual = listaGatos.get(i);                               // n
            int j = i - 1;                                                  // n
            while (j >= 0 && listaGatos.get(j).getId() > actual.getId()) {  // n*n= n^2
                listaGatos.set(j + 1, listaGatos.get(j));                   // n^2
                j--;                                                        // n^2                                             
            }
            listaGatos.set(j + 1, actual);                                  // n^2               
        }
        return listaGatos;
    }
}