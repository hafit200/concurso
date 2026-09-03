/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author LENOVO
 */
public class Participacion {

    private int idParticipacion;
    private Jugador jugador;
    private Equipo equipo;
    private Torneo torneo;

    public Participacion() {
    }

    public Participacion(int idParticipacion,
            Jugador jugador,
            Equipo equipo,
            Torneo torneo) {

        this.idParticipacion = idParticipacion;
        this.jugador = jugador;
        this.equipo = equipo;
        this.torneo = torneo;
    }

    public int getIdParticipacion() {
        return idParticipacion;
    }

    public void setIdParticipacion(int idParticipacion) {
        this.idParticipacion = idParticipacion;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
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
}
