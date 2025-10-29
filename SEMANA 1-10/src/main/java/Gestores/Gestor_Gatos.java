/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestores;

import Entidades.Gatos;
import Scanner.Lector;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class Gestor_Gatos {
    Lector lector=new Lector ();
    private static final String Ruta_gatos = "gatos.txt";

    // Recibe datos de un gato (id, nombre, edad y raza) y los guarda en el archivo gatos.txt
    public void guardarGato(int iD, String nombre, int edad, String raza, String estado_gato, String cuidado_requerido) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Ruta_gatos, true))) {
            bw.write(iD + "," + nombre + ","+ edad + ","+ raza + "," + estado_gato + "," + cuidado_requerido);
            bw.newLine();
            System.out.println("Gato agregado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar gato en el archivo.");
        }
    }     

    // Retorna una lista con todos los gatos que están almacenados en el archivo gatos.txt
    public List<Gatos> leerGatos() {
        List<Gatos> listaGatos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(Ruta_gatos))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 6) {
                    int id = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    int edad = Integer.parseInt(datos[2]);
                    String raza = datos[3];
                    String estado_gato = datos [4];
                    String cuidado_requerido = datos[5];
                    listaGatos.add(new Gatos(id, nombre, edad, raza,estado_gato, cuidado_requerido)); // Crear objeto y añadir a la lista
                }
            }
        } catch (IOException gestor_usuarie) {
            System.out.println("Error al leer gatos desde el archivo.");
        }
        return listaGatos;
    }
    
    // Permite registrar un nuevo gato solicitando sus datos por consola y 
    // guardándolos en el archivo mediante Gestor_usuarios.
    public void registrarGato() {      
        System.out.print("ID: ");
        int id = lector.LeerEntero();
        System.out.print("Nombre: ");
        String nombre = lector.LeerString();
        System.out.print("Edad: ");
        int edad = lector.LeerEntero();
        System.out.print("Raza: ");
        String raza = lector.LeerString();
        System.out.println("Estado del gato: (En adopción, Adoptado, En cuidado, En recuperación)");
        String estado_gato= lector.LeerString();
        System.out.println("Cuidado requerido:");
        String cuidado_requerido=lector.LeerString();
        
        guardarGato(id, nombre, edad, raza, estado_gato, cuidado_requerido);
    }

    // Metodo que muestra todos los gatos y su informacion
    public void listarGatos() {
        List<Gatos> gatos = leerGatos();

        if (gatos.isEmpty()) {
            System.out.println("No hay gatos registrados.");
        } else {
            int respuesta;
         do{ 
         System.out.println ("\n======================== Listar Gatos ========================");
         System.out.println("Como desea ver la lista?");
         System.out.println("1) Ordenamiento rápido (pasa colocando cada gato en su lugar)");       // insercion
         System.out.println("2) Ordenamiento paso a paso (compara de dos en dos)");                 // burbuja
         System.out.println("3) Ordenamiento escogiendo el más pequeño primero");                   // seleccion
         System.out.println("0) Volver");
         System.out.println("================================================================");
         respuesta=lector.LeerEntero();
         switch (respuesta){
             case 1:{
               List<Gatos> gatos1= lectorGatos(1); 
               if (gatos1.isEmpty()) {
                System.out.println("No hay gatos registrados.");
                } else {
                    System.out.println("================== Lista de gatos ==================");
                        for (Gatos g : gatos1) {
                        System.out.println(g); // usa el toString() de Gato
                        }
                    }
               break;
             }
             case 2: {
               List<Gatos> gatos2 = lectorGatos(2); 
               if (gatos2.isEmpty()) {
                System.out.println("No hay gatos registrados.");
                } else {
                    System.out.println("================== Lista de gatos ==================");
                        for (Gatos g : gatos2) {
                        System.out.println(g); // usa el toString() de Gato
                        }
                    }           
               break;
             }
             case 3: {
               List<Gatos> gatos3 = lectorGatos(3); 
               if (gatos3.isEmpty()) {
                System.out.println("No hay gatos registrados.");
                } else {
                    System.out.println("================== Lista de gatos ==================");
                        for (Gatos g : gatos3) {
                        System.out.println(g); // usa el toString() de Gato
                        }
                    }
               break; 
             }
             default: {
               System.out.println("Opción inválida.");
               break;
                }
            }
         }while (respuesta != 0);
        }
    }
    
        public List<Gatos> lectorGatos(int respuesta) {
        List<Gatos> listaGatos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(Ruta_gatos))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 6) {
                    int id = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    int edad = Integer.parseInt(datos[2]);
                    String raza = datos[3];
                    String estado_gato = datos [4];
                    String cuidado_requerido = datos[5];
                    listaGatos.add(new Gatos(id, nombre, edad, raza,estado_gato, cuidado_requerido)); // Crear objeto y añadir a la lista
                }
            }
        } catch (IOException gestor_usuarie) {
            System.out.println("Error al leer gatos desde el archivo.");
        }

        /** Ordena la lista de gatos por ID usando algoritmo de Inserción
        *   - Complejidad (Big-O):
        *   - Lectura del archivo: O(n), siendo n el número de gatos.
        *   - Ordenamiento por inserción:
        *   - Mejor caso (lista ya ordenada): O(n).
        *   - Peor caso (lista en orden descendente): O(n^2).
        *   - Complejidad total (dominante): O(n^2).
        */
        switch (respuesta){
            case 1: {
            for (int i = 1; i < listaGatos.size(); i++) {                       // n                       
                Gatos actual = listaGatos.get(i);                               // n
                int j = i - 1;                                                  // n
                while (j >= 0 && listaGatos.get(j).getId() > actual.getId()) {  // n*n= n^2
                    listaGatos.set(j + 1, listaGatos.get(j));                   // n^2
                    j--;                                                        // n^2                                             
                    }
                listaGatos.set(j + 1, actual);                                  // n^2               
                } 
            break;
            } 
        }
            return listaGatos;  
    }
    

    // Método publico que busca algun gato
    public void buscarGato() {
        List<Gatos> gatos = leerGatos();

        System.out.print("Ingrese el nombre del gato a buscar: ");
        String nombre_Buscado = lector.LeerString(); 

        boolean encontrado = false;

        // Buscar en la lista de gatos
        for (Gatos g : gatos) {
            if (g.getNombre().equalsIgnoreCase(nombre_Buscado)) {
                System.out.println("Gato encontrado:");
                System.out.println(g); // Se imprime gracias a toString()
                encontrado = true;
                break; 
            }
        }

        // Si no se encontró ningún gato con el nombre ingresado
        if (!encontrado){
            System.out.println("No se encontró un gato con ese nombre");
        }
    }
    
    public void modificar(){ 
        List<Gatos> gatos = leerGatos();
        boolean gato_correcto = false;  
        boolean intentardenuevo = true; 
        int id_Buscado;
            
        do{ 
            System.out.println("Ingrese Id del gato a modificar:");
            id_Buscado=lector.LeerEntero();
            
            for (Gatos g : gatos) {
                if (g.getId()==(id_Buscado)) {
                    gato_correcto=true;
                    break;                
                }else{
                    System.out.println("Gato no encontrado");                      
                    System.out.print("Desea intentar de nuevo? (si/no): ");
                    String volver = lector.LeerString();
                    // Si el usuario no quiere volver a intentar, salir del bucle
                    if (volver.equalsIgnoreCase("no")) {
                        intentardenuevo = false;
                        System.out.println("Regresando...");
                    }        
                }
            }
            
        }while (!gato_correcto && intentardenuevo);
        
        System.out.println("Que dato del gato desea modificar:");
        System.out.println("1) Nombre"); 
        System.out.println("2) Edad:");
        System.out.println("3) Estado");
        System.out.println("4) Cuidado requerido");      
        int modificacion=lector.LeerEntero();

        switch (modificacion){
            case 1: {
                System.out.println("Nuevo nombre: ");
                String nuevo=lector.LeerString();
                modificador(nuevo, id_Buscado, modificacion);
                break;
            }
            case 2: {
                System.out.println("Nueva edad: ");
                String nuevo=lector.LeerString();
                modificador(nuevo, id_Buscado, modificacion); 
                break;
            }
            case 3: {
                System.out.println("Nuevo estado del gato: ");
                String nuevo=lector.LeerString();
                modificador(nuevo, id_Buscado, modificacion);
                break;
            }
            case 4: { 
                System.out.println("Nuevo cuidado requerido: ");
                String nuevo=lector.LeerString();
                modificador(nuevo, id_Buscado, modificacion);
                break;
            }
            default: {
                System.out.println("Numero invalido");
            }           
        }       
    }
        private void guardarGatosModificados(List<Gatos> listaGatos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Ruta_gatos))) {
            for (Gatos g : listaGatos) {
                bw.write(g.getId() + "," + g.getNombre() + "," + g.getEdad() + "," +
                         g.getRaza() + "," + g.getEstado_gato() + "," + g.getCuidado_requerido());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los gatos: " + e.getMessage());
        }
    }
    
    public void modificador (String nuevo, int Id_gato, int modificador){       
        List<Gatos> listaGatos = leerGatos(); // Lee la lista
       
        boolean encontrado = false;
        for (Gatos g : listaGatos) {
            if (g.getId() == Id_gato) {
                encontrado = true;             
                    switch (modificador){
                        case 1: { 
                            System.out.println("Nuevo nombre: ");
                            g.setNombre(nuevo);
                            break;
                        }
                        case 2: {
                            System.out.println("Nueva edad: ");
                            int nuevo_entero=Integer.parseInt(nuevo);
                            g.setEdad(nuevo_entero);
                            break;
                        }
                        case 3: {
                            System.out.println("Nuevo estado del gato: ");
                            g.setEstado_gato(nuevo);
                            break;
                        }
                        case 4: { 
                            System.out.println("Nuevo cuidado requerido: ");
                            g.setCuidado_requerido(nuevo);
                            
                    }                       
                }
            }
        }
        if (encontrado){
            guardarGatosModificados(listaGatos);
            System.out.println("Gato modificado y guardado en el archivo.");
        } else {
            System.out.println("No se encontró el gato con ID " + Id_gato);
        }
    }
}
