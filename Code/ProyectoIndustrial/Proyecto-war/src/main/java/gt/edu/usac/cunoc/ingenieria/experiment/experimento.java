/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.experiment;

import java.io.Serializable;
import java.time.LocalDate;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author angelrg
 */
@Named
@ViewScoped
public class experimento implements Serializable {

    String name;
    String apellido;
    LocalDate fecha;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void printInfo() {
        System.out.println("Nombre: " + name);
        System.out.println("Apellido: " + apellido);
        System.out.println("Fecha: " + fecha.toString());
    }
}
