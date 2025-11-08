/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Menus;

import Entidades.Gatos;
import Gestores.Gestor_Gatos;
import Scanner.Lector;

/**
 *
 * @author admin
 */
public class Acciones_gatos implements Menu_Acciones  {
    Lector lector=new Lector ();
    Gestor_Gatos gestor= new Gestor_Gatos();
    @Override
    public void registrar() {
        System.out.println("\n========== REGISTRO ==========");
        System.out.print("ID: ");
        int id = lector.LeerEntero();
        System.out.print("Nombre: ");
        String nombre = lector.LeerString();
        System.out.print("Edad: ");
        int edad = lector.LeerEntero();
        System.out.print("Raza: ");
        String raza = lector.LeerString();
        System.out.print("Peso: ");
        double peso = lector.LeerDouble();
        System.out.print("Genero: ");
        String genero= lector.LeerString();
        System.out.print("Estilizacion: ");
        String esterilizacion= lector.LeerString();
        System.out.print("Estado del gato: (En adopción, Adoptado, En cuidado, En recuperación)");
        String estado_gato= lector.LeerString();
        System.out.print("Cuidado requerido:");
        String cuidado_requerido=lector.LeerString();
        
        gestor.registrar(new Gatos(id,nombre,edad,raza,peso, genero,esterilizacion,estado_gato,cuidado_requerido));
    }
    //muestra la lista :)
    @Override
    public void Listar() {
        gestor.mostrar();
    }

    @Override
    public void Buscar() {
        System.out.print("Ingrese el nombre  o Id del gato que desea buscar: ");
        String gatoBuscado= lector.LeerString();
        if (gestor.existe(gatoBuscado)==true){
            gestor.buscar(gatoBuscado);
            }else {
            System.out.println("Gatito no encontrado");
        }      
    }

    @Override
    public void modificar() {
        System.out.println("\n======= MODIFICAR DATOS =======");
        System.out.print("Ingrese el nombre o ID del gato que desea modificar: ");
        String gatoModificar= lector.LeerString();
        int opcion;
        if (gestor.existe(gatoModificar)== true){
            boolean seguir; //va a iniciar como si el usuario quisiera continuar modificando
            do{                     
                System.out.println("Que dato desea modificar: ");
                System.out.println("1) Nombre: ");
                System.out.println("2) Edad: ");
                System.out.println("3) Raza: ");
                System.out.println("4) Peso: ");
                System.out.println("5) Esterilizacion: ");
                System.out.println("6) Estado del gato: ");
                System.out.println("7) Cuidados requeridos: ");
                System.out.print("Ingrese una opcion: ");
                opcion=lector.LeerEntero();
                gestor.modificar(gatoModificar, opcion);
                System.out.print("Desea modificar otro dato?: (si/no)");
                String respuesta=lector.LeerString();
                seguir= respuesta.equalsIgnoreCase("si"); //? true:false
            }while (seguir);
            System.out.println("Datos modificados exitosamente! ");
        } else {
            System.out.println("Gatito no encontrado");
        }
    }
}
