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
    
    // Atributo estático y constante (static final):
    // - static: porque es compartido por todas las instancias de la clase.
    // - final: porque no cambia nunca (constante).
    // Se usa para almacenar la ruta del archivo de usuarios.
    private static final String Ruta_archivo = "usuarios.txt";

    // Atributo estático y constante (static final):
    // Se usa para almacenar la ruta del archivo de gatos.
    private static final String Ruta_gatos = "gatos.txt";

    // ========================
    // MÉTODOS
    // ========================

    /**
     * Método público y paramétrico.
     * Parámetros: usuario (String), contraseña (String).
     * Función: Registra un nuevo usuario en el archivo de texto "usuarios.txt".
     * Uso de try-with-resources para asegurar que el archivo se cierre automáticamente.
     */
    public void registrar_usuario(String usuario, String contraseña) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Ruta_archivo, true))) {
            bw.write(usuario + "," + contraseña); // Escribe el usuario y contraseña en formato CSV.
            bw.newLine(); // Pasa a la siguiente línea.
            System.out.println("Usuario agregado correctamente.");
        } catch (IOException ex) {
            System.out.println("Error al leer usuarios.txt");
        }
    }

    /**
     * Método público y paramétrico.
     * Parámetros: usuario (String), contraseña (String).
     * Retorna: boolean → true si el login es correcto, false si falla.
     * Función: Lee el archivo "usuarios.txt" y valida si existe el usuario con la contraseña.
     */
    public boolean login(String usuario, String contraseña) {
        try (BufferedReader br = new BufferedReader(new FileReader(Ruta_archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(","); // Divide cada línea en usuario y contraseña.
                if (datos.length == 2) {
                    String validarUsuario = datos[0];
                    String validarUser = datos[1];
                    // Verifica si el usuario y la contraseña coinciden
                    if (validarUsuario.equals(usuario) && validarUser.equals(contraseña)) {
                        return true;
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Error leyendo archivo: ");
        }
        return false;
    }

    /**
     * Método público y paramétrico.
     * Parámetros: iD (int), nombre (String), edad (int), raza (String).
     * Función: Guarda un gato en el archivo "gatos.txt" con sus atributos.
     */
    public void guardarGato(int iD, String nombre, int edad, String Raza) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Ruta_gatos, true))) {
            bw.write(iD + "," + nombre + "," + edad + "," + Raza); // Guarda los datos en formato CSV.
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
        *   - Peor caso (lista en orden descendente): O(n²).
        *   - Complejidad total (dominante): O(n²).
        */
        for (int i = 1; i < listaGatos.size(); i++) {
            Gatos actual = listaGatos.get(i);
            int j = i - 1;
            while (j >= 0 && listaGatos.get(j).getId() > actual.getId()) {
                listaGatos.set(j + 1, listaGatos.get(j));
                j--;
            }
            listaGatos.set(j + 1, actual);
        }
        return listaGatos;
    }
}