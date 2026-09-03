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

public class Torneo {

    private int idTorneo;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Juego juego;
    private double premioTotal;
    private String estado;

    public Torneo() {
    }

    public Torneo(int idTorneo,
            String nombre,
            LocalDate fechaInicio,
            LocalDate fechaFin,
            Juego juego,
            double premioTotal,
            String estado) {

        this.idTorneo = idTorneo;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.juego = juego;
        this.premioTotal = premioTotal;
        this.estado = estado;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public double getPremioTotal() {
        return premioTotal;
    }

    public void setPremioTotal(double premioTotal) {
        this.premioTotal = premioTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}