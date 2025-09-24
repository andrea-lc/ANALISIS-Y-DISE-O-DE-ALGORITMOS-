/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana7;

import Scanner.Lector;

/**
 *
 * @author admin
 */
public class Semana7 {

    public static void main(String[] args) {
        Lector lector=new Lector();

        // Instancia del gestor de usuarios (encargado de manejar login y registro)
        Gestor_usuarios gu = new Gestor_usuarios();

        int opcion;

        do {
            System.out.println("\n========== Cat Haven ==========");
            System.out.println("1) Iniciar sesion");
            System.out.println("2) Registrar nuevo Usuario");
            System.out.println("3) Salir");
            System.out.println("================================");

            opcion = lector.LeerEntero();

            switch (opcion) {
                case 1: { 
                    // Caso 1: Iniciar sesión
                    boolean logincorrecto = false;  
                    boolean intentardenuevo = true; 

                    // Bucle que permite intentar el login varias veces
                    do {
                        // Pedir credenciales
                        System.out.print("Correo: ");
                        String correo = lector.LeerString();

                        System.out.print("Contraseña: ");
                        String contraseña = lector.LeerString();
                                
                        // Verificar credenciales llamando al metodo login del gestor de usuarios
                        if (gu.login(correo, contraseña)) {

                        logincorrecto = true; // Login correcto
                        } else {
                            // Mensaje de error si las credenciales no coinciden
                            System.out.println("Correo o contraseña incorrectos.");
                            System.out.print("Desea intentar de nuevo? (si/no): ");
                            String volvermenu = lector.LeerString();

                            // Si el usuario no quiere volver a intentar, salir del bucle
                            if (volvermenu.equalsIgnoreCase("no")) {
                                intentardenuevo = false;
                                System.out.println("Regresando al menú principal...");
                            }
                        }
                    } while (!logincorrecto && intentardenuevo); 
                    // Repetir si no ha hecho login y quiere volver a intentarlo
                    break;
                }
                case 2: {
                    // Caso 2: Registrar un nuevo usuario
                    
                    System.out.print("Correo: ");
                    String correo = lector.LeerString();
                    
                    System.out.print("Nombre de Usuario: ");
                     String user_name1 = lector.LeerString();

                    System.out.print("Cree una contraseña: ");
                    String contraseña1 = lector.LeerString();

                    // Llamar al método del gestor para registrar un nuevo usuario
                    gu.registrar_usuario(correo,user_name1, contraseña1);
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
        } while (opcion != 3); // Condicion de salida: si elige "3", termina el programa
    }
}
