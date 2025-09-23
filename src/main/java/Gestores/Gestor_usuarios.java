/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author admin
 */
// Clase Gestor_usuarios
public class Gestor_usuarios {

    // ========================
    // ATRIBUTOS
    // ========================

    private static final String Ruta_archivo = "usuarios.txt";

    // ========================
    // MÉTODOS
    // ========================

    public void registrar_usuario(String correo, String usuario, String contraseña) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Ruta_archivo, true))) {
            bw.write(correo+ ","+ usuario + "," + contraseña); // Guardar en formato CSV
            bw.newLine();
            System.out.println("Usuario agregado correctamente.");
        } catch (IOException ex) {
            System.out.println("Error al leer usuarios.txt");
        }      
    }
    

    // Recibe usuario y contraseña como parámetros.
    public boolean login(String correo, String contraseña) {
        try (BufferedReader br = new BufferedReader(new FileReader(Ruta_archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    String validarCorreo = datos[0];
                    String validarContra = datos[2];
                    if (validarCorreo.equals(correo) && validarContra.equals(contraseña)) {
                        return true; // Credenciales correctas
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Error leyendo archivo de usuarios.");
        }
        return false; // Si no encuentra coincidencia
    }
}

