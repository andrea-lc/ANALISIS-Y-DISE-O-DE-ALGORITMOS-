/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestores;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 * @param <t>
 */
public abstract class GestorBase <t> implements GestorInterface<t> {
    protected Map<String, t> elementos = new HashMap<>();
    protected final String rutaArchivo;
    
    
    
    public GestorBase(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        cargarDatos();
    }
    
    public Map<String, t> getElementos() {
        return elementos;
    }
}
