/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ada_project;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class ADA_project {
        // Método principal (punto de entrada del programa)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instancia del gestor de usuarios (encargado de manejar login y registro)
        Gestor_usuarios gu = new Gestor_usuarios();

        // Instancia del menú (para mostrar opciones adicionales después de iniciar sesión)
        Menu2 menu = new Menu2();
        int opcion;

        // Bucle principal que mantiene el menú activo hasta que el usuario elija salir (opción 3)
        do {
            System.out.println("\n========== Cat Haven ==========");
            System.out.println("1) Iniciar sesion");
            System.out.println("2) Registrar nuevo Usuario");
            System.out.println("3) Salir");
            System.out.println("================================");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1: { 
                    // Caso 1: Iniciar sesión
                    boolean logincorrecto = false;  
                    boolean intentardenuevo = false; 

                    // Bucle que permite intentar el login varias veces
                    do {
                        // Pedir credenciales
                        System.out.println("Nombre de Usuario: ");
                        String user_name = scanner.nextLine();

                        System.out.println("Contraseña: ");
                        String contraseña = scanner.nextLine();

                        // Verificar credenciales llamando al método login del gestor de usuarios
                        if (gu.login(user_name, contraseña)) {
                            System.out.println("Ingresando...");
                            logincorrecto = true; // Login correcto
                            menu.mostrar();       // Mostrar menú secundario (una vez logeado)
                        } else {
                            // Mensaje de error si las credenciales no coinciden
                            System.out.println("Usuario o contraseña incorrectos.");
                            System.out.print("Desea intentar de nuevo? (si/no): ");
                            String volvermenu = scanner.nextLine();

                            // Si el usuario no quiere volver a intentar, salir del bucle
                            if (volvermenu.equalsIgnoreCase("no")) {
                                intentardenuevo = false;
                                System.out.println("Regresando al menú principal...");
                            }
                        }
                    } while (!logincorrecto && intentardenuevo); // Repetir si no ha hecho login y quiere volver a intentarlo
                    break;
                }
                case 2: {
                    // Caso 2: Registrar un nuevo usuario
                    System.out.println("Nombre de Usuario: ");
                    String user_name1 = scanner.nextLine();

                    System.out.println("Cree una contraseña: ");
                    String contraseña1 = scanner.nextLine();

                    // Llamar al método del gestor para registrar un nuevo usuario
                    gu.registrar_usuario(user_name1, contraseña1);
                    break;
                }
                case 3: {
                    // Caso 3: Salir del programa
                    // No se hace nada, el bucle terminará porque opcion = 3
                    break;
                }
                default:
                    // Manejo de entrada inválida
                    System.out.println("Ingrese una opcion valida");
            }
        } while (opcion != 3); // Condición de salida: si elige "3", termina el programa
    }
}