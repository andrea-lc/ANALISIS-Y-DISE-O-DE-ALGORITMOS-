/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject4;

/**
 *
 * @author admin
 */
public class Prueba {  
    public static boolean resolver(int[][] s) {
        // forma de recorrer el arreglo bidimencional 
        for (int f = 0; f < 4; f++) {
            for (int c = 0; c < 4; c++) {
                
                // Si la casilla esta vacia osea tiene un 0 
                if (s[f][c] == 0) {
                    
                    // Probar numeros del 1 al 4
                    for (int n = 1; n <= 4; n++) {
                        
                        /* Verificar si el numero es valido                      
                        * s: arreglo
                        * f: fila
                        * c: columna
                        * n: numero que ira recorriendo del 1 al 4 para ver cual es la mejor opcion
                        */        
                        
                        if (esValido(s, f, c, n)) {
                            s[f][c] = n;  // Poner el número
                            
                            // Intentar resolver el resto
                            if (resolver(s)) {
                                return true;  // funciona
                            }
                            
                            s[f][c] = 0;  // quitar el numero (backtracking)
                        }
                    }
                    return false;  // ningun numero funciono
                }
            }
        }
        return true;  // no hay mas casillas vacias
    }

    // Verifica si un numero puede ir en una posicion
    public static boolean esValido(int[][] s, int fila, int col, int num) {
        // revisar fila
        // verifica si el numero se repite en la fila para ve rsi lo puede poner o no
        for (int c = 0; c < 4; c++) {
            if (s[fila][c] == num) return false; 
        }
        
        // revisar columna
        // verifica si el numero se repite en la columna para ve si lo puede poner o no
        for (int f = 0; f < 4; f++) {
            if (s[f][col] == num) return false;
        }
        
        // revisar cuadro 2x2
        int inicioFila = (fila / 2) * 2;  
        int inicioCol = (col / 2) * 2;   
        
        for (int f = inicioFila; f < inicioFila + 2; f++) {
            for (int c = inicioCol; c < inicioCol + 2; c++) {
                if (s[f][c] == num) return false;
            }
        }
        
        return true;  // El numero es valido
    }

    // mostrar el tablero
    public static void mostrar(int[][] s) {
        for (int f = 0; f < 4; f++) {
            for (int c = 0; c < 4; c++) {
                System.out.print(s[f][c] + " ");
            }
            System.out.println();
        }
    }
}

