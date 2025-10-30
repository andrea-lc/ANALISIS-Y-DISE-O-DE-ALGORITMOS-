/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ada_semana12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author admin
 */
public class Ada_semana12 {

    public static void main(String[] args) {        
        // Busqueda lineal (no necesita orden)
        List<Integer> lista = new ArrayList<>();
        lista.add(5);
        lista.add(2);
        lista.add(8);
        lista.add(1);
        lista.add(9);
        System.out.println("Lista: "+lista);
        System.out.println("Busqueda lineal");
        int buscar = 7;
        boolean encontre = false;
        
        // Recorre la lista y verifica 
        for(int num : lista) {
            if(num == buscar) {
                encontre = true;
            }
        }
        
        if(encontre) {
            System.out.println("Si esta en la lista");
        } else {
            System.out.println("No esta en la lista");
        }
    
        System.out.println("\nBusqueda Binaria");
        // Busqueda binaria (requiere ordenar primero)
        Collections.sort(lista);
        System.out.println(lista);
        int pos = Collections.binarySearch(lista, 7);
        System.out.println("BinarySearch posicion: " + pos); 
        System.out.println("Si devuelve un numero negativo significa que no lo encontro");
    }
}
   