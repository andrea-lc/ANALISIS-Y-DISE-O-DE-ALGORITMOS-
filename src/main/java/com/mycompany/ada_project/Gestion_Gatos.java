/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ada_project;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
class Gestion_Gatos {
    private final Scanner scanner;

    public Gestion_Gatos(Scanner scanner) {
        this.scanner = scanner;
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== Gestión de Gatos ===");
            System.out.println("1) Registrar nuevo gato");
            System.out.println("2) Listar gatos");
            System.out.println("3) Buscar gato por ID");
            System.out.println("0) Volver");
            System.out.println("========================");
            System.out.print("Elige una opción: ");
            
            opcion = leerEntero();

            switch (opcion) {
                case 1: {
                    registrarGato();
                    break;
                }
                case 2: {
                    listarGatos();
                    break;
                }
                case 3: {
                    buscarGato();
                    break;
                }
                case 0: {
                    System.out.println("Volviendo al menú principal...");
                    break;
                }
                default: {
                    System.out.println("Opción inválida.");
                }
            }
        } while (opcion != 0);
    }

    private int leerEntero() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Ingresa un número válido: ");
            }
        }
    }

    private void registrarGato() {      
        System.out.print("ID: ");
        int id = leerEntero();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = leerEntero();
        System.out.print("Raza: ");
        String raza = scanner.nextLine();
        
        Gestor_usuarios gestor_gatos = new Gestor_usuarios();
        gestor_gatos.guardarGato(id, nombre, edad, raza);
    }

    private void listarGatos() {
         Gestor_usuarios gestor = new Gestor_usuarios();
         List<Gatos> gatos = gestor.leerGatos();

        if (gatos.isEmpty()) {
            System.out.println("No hay gatos registrados.");
        } else {
            System.out.println("=== Lista de gatos ===");
            for (Gatos g : gatos) {
                System.out.println(g); // usa el toString() de Gato
            }
        }
    }

    private void buscarGato() {
        Gestor_usuarios gestor = new Gestor_usuarios();
        List<Gatos> gatos = gestor.leerGatos();

        System.out.print("Ingrese el ID del gato a buscar: ");
        int idBuscado = leerEntero(); 

        boolean encontrado = false;

        for (Gatos g : gatos) {
            if (g.getId() == idBuscado) {
                System.out.println("Gato encontrado:");
                System.out.println(g); 
                encontrado = true;
                break; // salimos del bucle, ya encontramos el gato
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró un gato con ese ID.");
            }
        }
}
