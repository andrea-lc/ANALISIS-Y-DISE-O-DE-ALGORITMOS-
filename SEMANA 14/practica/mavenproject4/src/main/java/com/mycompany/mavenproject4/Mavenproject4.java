/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject4;

/**
 *
 * @author admin
 */
public class Mavenproject4 {
    public static void main(String[] args) {
        
        // Tablero 4x4 (0 = vacío)
        int[][] sudoku = {
            {1, 2, 0, 0},
            {0, 0, 0, 2},
            {3, 0, 0, 0},
            {0, 0, 1, 0}
        };

        System.out.println("Sudoku inicial:");
        Prueba.mostrar(sudoku);
        
        if (Prueba.resolver(sudoku)) {
            System.out.println("\nRESUELTO");
            Prueba.mostrar(sudoku);
        } else {
            System.out.println("No se pudo resolver");
        }
    }    
}
