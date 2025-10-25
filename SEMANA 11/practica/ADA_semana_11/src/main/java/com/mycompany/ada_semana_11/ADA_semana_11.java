/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ada_semana_11;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author admin
 */
public class ADA_semana_11 {

    public static void main(String[] args) {
        int[] array = new int[100];
        Random rand = new Random();
        
        for (int i = 0; i < 100; i++) {
            array[i] = rand.nextInt(1000);
        }
        
        System.out.println("Array original: " + Arrays.toString(array));
        
        Arrays.sort(array);
        
        System.out.println("Array ordenado: " + Arrays.toString(array));
    }
}
   