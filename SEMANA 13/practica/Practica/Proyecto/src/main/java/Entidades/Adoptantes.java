/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author admin
 */
public class Adoptantes extends Persona {
    String fecha_adopcion;
    String observaciones;

    public Adoptantes(Persona persona, String fecha_adopcion, String observaciones) {
        super (persona);
        this.fecha_adopcion = fecha_adopcion;
        this.observaciones = observaciones;
    }

    public String getFecha() {
        return fecha_adopcion;
    }

    public void setFecha(String fecha) {
        this.fecha_adopcion = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
