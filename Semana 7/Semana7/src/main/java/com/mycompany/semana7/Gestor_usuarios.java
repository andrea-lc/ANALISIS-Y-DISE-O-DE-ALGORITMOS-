package com.mycompany.semana7;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
// Clase Gestor_usuarios
public class Gestor_usuarios {

    private static final String Ruta_archivo = "usuarios.txt";
    private static Map<String, String> usuarios = new HashMap<>();
    private static Map<String, String> nombres = new HashMap<>();
    
    
    //problema: no leia el txt ya que el hashmap estaba vacio 
    // solucion: crear constructor para llamar al metodo y cada vez que se instancie, el map se inicializara  con los datos llenos
    public Gestor_usuarios() {
        cargarUsuarios(); // <---(ejecuta el metodo cargarUsuarios para que los datos de txt llenen el map
    }
    
    
    private void cargarUsuarios() {
        try (BufferedReader br = new BufferedReader(new FileReader(Ruta_archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    usuarios.put(datos[0], datos[2]); // correo -> contraseña
                    nombres.put(datos[0],datos[1]); // correo -> nombre de usuario
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar usuarios (puede que el archivo esté vacio).");
        }
    }


    public void registrar_usuario(String correo, String usuario, String contraseña) {
        if (usuarios.containsKey(correo)) {   //verifica si el map contiene la clave
            System.out.println("Ese correo ya está registrado.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Ruta_archivo, true))) {
            bw.write(correo + "," + usuario + "," + contraseña);
            bw.newLine();
            System.out.println("Usuario agregado correctamente.");

            // También se guarda en el hashmap
            usuarios.put(correo, contraseña);
            nombres.put (correo,usuario);

        } catch (IOException ex) {
            System.out.println("Error al guardar en usuarios.txt");
        }
    }
    
    // Recibe usuario y contraseña como parámetros.
    public boolean login(String correo, String contraseña) {
        if (!usuarios.containsKey(correo)) {   
            return false; // correo (usuario) no encontrado
            
        }

        String contraGuardada = usuarios.get(correo); // devolvera el valor asociado a la clave "correo"
        String usuario= nombres.get(correo);

        if (contraGuardada.equals(contraseña)) {
            System.out.println("Bienvenido "+ usuario);
            return true;  // login correcto
        } else {
            return false; // contraseña incorrecta
        }
    }
}

