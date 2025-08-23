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
     //ATRIBUTOS
    
    private static final String Ruta_archivo = "usuarios.txt";
    private static final String Ruta_gatos = "gatos.txt";
    //METODOS
    public void registrar_usuario (String usuario,String contraseña){
        try(BufferedWriter bw= new BufferedWriter (new FileWriter(Ruta_archivo,true)) ){
            bw.write(usuario + "," + contraseña);
            bw.newLine();
            System.out.println("Usuario agregado correctamente.");
        } catch (IOException ex) {
            System.out.println("Error al leer usuarios.txt");
        }      
    }
    
       public boolean login(String usuario, String contraseña) {
        try (BufferedReader br = new BufferedReader(new FileReader(Ruta_archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 2) {
                    String validarUsuario = datos[0];
                    String validarUser = datos[1];
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
       
       public void guardarGato(int iD, String nombre, int edad, String Raza) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Ruta_gatos, true))) {
            bw.write(iD + "," + nombre + ","+ edad + ","+ Raza);
            bw.newLine();
            System.out.println("Gato agregado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar gato en el archivo.");
        }
    }

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
                    listaGatos.add(new Gatos(id, nombre, edad, raza));
            }
        }
    } catch (IOException e) {
        System.out.println("Error al leer gatos desde el archivo.");
    }
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

