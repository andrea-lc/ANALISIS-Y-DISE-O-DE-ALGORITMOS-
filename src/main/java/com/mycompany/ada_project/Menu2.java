/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ada_project;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Menu2 {
    // ========================
    // ATRIBUTOS
    // ========================
    private final Scanner scanner = new Scanner(System.in);
    // ========================
    // MÉTODOS
    // ========================

    // Método público, no paramétrico y sin retorno (void).
    // Se encarga de mostrar el menú principal en consola
    public void mostrar() {
        int opcion;
        do {
            System.out.println("\n========== Cat Haven ==========");
            System.out.println("1) Gestión de gatos");
            System.out.println("2) Gestión de clientes");
            System.out.println("3) Adopciones");
            System.out.println("4) Reportes");
            System.out.println("0) Cerrar sesión");
            System.out.println("================================");
            System.out.print("Elige una opción: ");
            
            // Leer opción ingresada por el usuario
            opcion = leerEntero();

            switch (opcion) {
                case 1: {
                    // Caso 1: Llama al módulo de gestión de gatos
                    Gestion_Gatos gestor_gatos = new Gestion_Gatos(scanner);
                    gestor_gatos.mostrarMenu();
                    break;
                }
                case 2: {
                    // Caso 2: Módulo de clientes (a implementar)
                    System.out.println("Aquí irá el módulo de clientes...");
                    break;
                }
                case 3: {
                    // Caso 3: Módulo de adopciones (a implementar)
                    System.out.println("Aquí irá el módulo de adopciones...");
                    break;
                }
                case 4: {
                    // Caso 4: Módulo de reportes (a implementar)
                    System.out.println("Aquí irá el módulo de reportes...");
                    break;
                }
                case 0: {
                    // Caso 0: Salir del sistema
                    System.out.println("Cerrando sesión...");
                    break;
                }
                default: {
                    // Opción inválida: mensaje de error
                    System.out.println("Opción inválida.");
                }
            }
        } while (opcion != 0); // Repite hasta que el usuario elija salir
    }

    // Método privado, no paramétrico y con retorno (int).
    // Intenta leer un número entero desde la consola.
    // Si el usuario ingresa algo inválido, muestra un mensaje y vuelve a pedir el valor.
    private int leerEntero() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Ingresa un número válido: ");
            }
        }
    }
}