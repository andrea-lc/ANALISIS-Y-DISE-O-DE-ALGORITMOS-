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
        private final Scanner scanner = new Scanner(System.in);

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
            
            opcion = leerEntero();

            switch (opcion) {
                case 1: {
                    Gestion_Gatos gestor_gatos = new Gestion_Gatos(scanner);
                    gestor_gatos.mostrarMenu();
                    break;
                }
                case 2: {
                    System.out.println("Aquí irá el módulo de clientes...");
                    break;
                }
                case 3: {
                    System.out.println("Aquí irá el módulo de adopciones...");
                    break;
                }
                case 4: {
                    System.out.println("Aquí irá el módulo de reportes...");
                    break;
                }
                case 0: {
                    System.out.println("Cerrando sesión...");
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
}


