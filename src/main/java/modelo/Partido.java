/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Date;
import java.sql.Time;
/**
 *
 * @author LENOVO
 */
import java.time.LocalDate;
import java.time.LocalTime;

public class Partido {

    private int idPartido;
    private Ronda ronda;
    private Equipo equipo1;
    private Equipo equipo2;
    private LocalDate fecha;
    private LocalTime hora;
    private Integer marcadorEquipo1;
    private Integer marcadorEquipo2;
    private Arbitro arbitro;
    private Sede sede;

    public Partido() {
    }

    public Partido(int idPartido,
            Ronda ronda,
            Equipo equipo1,
            Equipo equipo2,
            LocalDate fecha,
            LocalTime hora,
            Integer marcadorEquipo1,
            Integer marcadorEquipo2,
            Arbitro arbitro,
            Sede sede) {

        this.idPartido = idPartido;
        this.ronda = ronda;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.fecha = fecha;
        this.hora = hora;
        this.marcadorEquipo1 = marcadorEquipo1;
        this.marcadorEquipo2 = marcadorEquipo2;
        this.arbitro = arbitro;
        this.sede = sede;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public Ronda getRonda() {
        return ronda;
    }

    public void setRonda(Ronda ronda) {
        this.ronda = ronda;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Integer getMarcadorEquipo1() {
        return marcadorEquipo1;
    }

    public void setMarcadorEquipo1(Integer marcadorEquipo1) {
        this.marcadorEquipo1 = marcadorEquipo1;
    }

    public Integer getMarcadorEquipo2() {
        return marcadorEquipo2;
    }

    public void setMarcadorEquipo2(Integer marcadorEquipo2) {
        this.marcadorEquipo2 = marcadorEquipo2;
    }

    public Arbitro getArbitro() {
        return arbitro;
    }

    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }
}
