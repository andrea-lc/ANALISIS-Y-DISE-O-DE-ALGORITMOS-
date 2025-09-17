/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ada_project;

/**
 *
 * @author admin
 */
class Lector {
    private final java.util.Scanner scanner = new java.util.Scanner(System.in);
    
    public int LeerEntero (){
        while (true){
            try {
                String salida=scanner.nextLine().trim();               
                return Integer.parseInt(salida);               
            }catch (NumberFormatException e){
                System.out.println("Ingrese un numero valido: ");
            }
        }
    }
    public String LeerString () {
     while (true){
         String salida=scanner.nextLine().trim();
            if (!salida.isEmpty()){
              return salida;
            } else {
                System.out.println("Ingrese un dato valido: ");
            }
        }
    }
}

