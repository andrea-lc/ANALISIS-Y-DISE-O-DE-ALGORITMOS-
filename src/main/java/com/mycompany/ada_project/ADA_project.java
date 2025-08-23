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
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Gestor_usuarios gu = new Gestor_usuarios();
    Menu2 menu2=new Menu2();
    int opcion;
    do {
        System.out.println("\n========== Cat Haven ==========");
        System.out.println("1) Iniciar sesion");
        System.out.println("2) Registrar nuevo Usuario");
        System.out.println("3) Salir");
        System.out.println("================================");

        opcion = scanner.nextInt();
        scanner.nextLine(); 

        switch (opcion) {
            case 1: {
                boolean logincorrecto = false;
                boolean intentardenuevo = true;
                do {
                    System.out.println("Nombre de Usuario: ");
                    String user_name = scanner.nextLine();
                    System.out.println("Contraseña: ");
                    String contraseña = scanner.nextLine();
                    if (gu.login(user_name, contraseña)) {
                        System.out.println("Ingresando...");
                        logincorrecto = true;
                        menu2.mostrar();
                    } else {
                        System.out.println("Usuario o contraseña incorrectos.");
                        System.out.print("Desea intentar de nuevo? (si/no): ");
                        String volvermenu = scanner.nextLine();

                        if (volvermenu.equalsIgnoreCase("no")) {
                            intentardenuevo = false;
                            System.out.println("Regresando al menú principal...");
                        }
                    }
                } while (!logincorrecto && intentardenuevo);
                break;
            }
            case 2: {
                System.out.println("Nombre de Usuario: ");
                String user_name1 = scanner.nextLine();

                System.out.println("Cree una contraseña: ");
                String contraseña1 = scanner.nextLine();
                gu.registrar_usuario(user_name1, contraseña1);
                break;
            }
            case 3: {
                // salir
                break;
            }
            default:
                System.out.println("Ingrese una opcion valida");
        }
    } while (opcion != 3);
}
}
