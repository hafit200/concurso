/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author LENOVO
 */
public class Patrocinio {

    private int idPatrocinio;
    private Patrocinador patrocinador;
    private Torneo torneo;
    private double montoAportado;

    public Patrocinio() {
    }

    public Patrocinio(int idPatrocinio,
            Patrocinador patrocinador,
            Torneo torneo,
            double montoAportado) {

        this.idPatrocinio = idPatrocinio;
        this.patrocinador = patrocinador;
        this.torneo = torneo;
        this.montoAportado = montoAportado;
    }

    public int getIdPatrocinio() {
        return idPatrocinio;
    }

    public void setIdPatrocinio(int idPatrocinio) {
        this.idPatrocinio = idPatrocinio;
    }

    public Patrocinador getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(Patrocinador patrocinador) {
        this.patrocinador = patrocinador;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    public double getMontoAportado() {
        return montoAportado;
    }

    public void setMontoAportado(double montoAportado) {
        this.montoAportado = montoAportado;
    }
}
