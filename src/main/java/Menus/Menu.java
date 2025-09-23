/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import Gestores.Gestor_Gatos;
import Scanner.Lector;

/**
 *
 * @author admin
 */
public class Menu {
        
    Lector lector=new Lector ();

    // Se encarga de mostrar el menú principal en consola
    public void mostrar() {    
        int opcion;
        do {
            System.out.println("\n========== Cat Haven ==========");
            System.out.println("1) Gestión de gatos");
            System.out.println("2) Gestión de adopciones");
            System.out.println("3) Adopciones");
            System.out.println("4) Reportes");
            System.out.println("0) Cerrar sesión");
            System.out.println("================================");
            System.out.print("Elige una opción: ");
            
            // Leer opción ingresada por el usuario
            opcion = lector.LeerEntero();

            switch (opcion) {
                case 1: {
                    // Caso 1: Llama al módulo de gestión de gatos
                    mostrarMenuGatos();
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
    
    // Muestra el submenú sobre gatos y maneja las opciones.
    public void mostrarMenuGatos() {
        Gestor_Gatos gestor_gatos = new Gestor_Gatos();

        int opcion;
        do {
            System.out.println("\n=== Gestión de Gatos ===");
            System.out.println("1) Registrar nuevo gato");
            System.out.println("2) Listar gatos");
            System.out.println("3) Buscar gato por nombre");
            System.out.println("4) Modificar algun dato");
            System.out.println("0) Volver");
            System.out.println("========================");
            System.out.print("Elige una opción: ");
            
            // Leer la opcion elegida
            opcion = lector.LeerEntero();

            // Manejar la opción seleccionada
            switch (opcion) {
                case 1: {
                    // Registrar un nuevo gato
                    gestor_gatos.registrarGato();
                    break;
                }
                case 2: {
                    // Listar todos los gatos
                    gestor_gatos.listarGatos();
                    break;
                }
                case 3: {
                    // Buscar un gato por su ID
                    gestor_gatos.buscarGato();
                    break;
                }
                case 4: 
                    // Modificar algun dato
                    gestor_gatos.modificar();
                    
                case 0: {
                    // Volver al menú principal
                    System.out.println("Volviendo al menú principal...");
                    break;
                }
                default: {
                    // Manejo de opción inválida
                    System.out.println("Opción inválida.");
                }
            }
        } while (opcion != 0); // Se repite hasta que el usuario decida salir
    }
}