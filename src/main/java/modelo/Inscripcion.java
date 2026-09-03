/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author LENOVO
 */
import java.time.LocalDate;

public class Inscripcion {

    private int idInscripcion;
    private Equipo equipo;
    private Torneo torneo;
    private LocalDate fechaInscripcion;
    private Integer posicionFinal;

    public Inscripcion() {
    }

    public Inscripcion(int idInscripcion,
            Equipo equipo,
            Torneo torneo,
            LocalDate fechaInscripcion,
            Integer posicionFinal) {

        this.idInscripcion = idInscripcion;
        this.equipo = equipo;
        this.torneo = torneo;
        this.fechaInscripcion = fechaInscripcion;
        this.posicionFinal = posicionFinal;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Integer getPosicionFinal() {
        return posicionFinal;
    }

    public void setPosicionFinal(Integer posicionFinal) {
        this.posicionFinal = posicionFinal;
    }
}
