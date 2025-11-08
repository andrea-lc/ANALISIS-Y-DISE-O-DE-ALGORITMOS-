/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Gestores;

import java.util.List;

/**
 *
 * @author admin
 * @param <T>
 */
public interface GestorInterface <T> {
    void cargarDatos();
    void guardarCambios();
    boolean registrar(T elemento);
    boolean existe(String identificador);
    void mostrar ();
    void modificar (String datoModificar, int opcion);
    List<T> ordenar();
    T buscar (String identificador);
}
