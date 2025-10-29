/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import Entidades.Persona;
import java.time.LocalDate;

/**
 *
 * @author admin
 */
public class Adoptantes extends Persona {
    LocalDate fecha;
    String observaciones;

    public Adoptantes(LocalDate fecha, String observaciones, int id_persona, String nombre, int telefono, String direccion, String correo) {
        super(id_persona, nombre, telefono, direccion, correo);
        this.fecha = fecha;
        this.observaciones = observaciones;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
