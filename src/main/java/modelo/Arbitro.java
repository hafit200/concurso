/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author LENOVO
 */
public class Arbitro extends Usuario {

    private Juego juegoEspecialidad;
    private String nivelCertificacion;
    private int torneosArbitrados;

    public Arbitro() {
        super();
    }

    public Arbitro(int idUsuario,
            String nombre,
            String correo,
            String password,
            String estado,
            String nivelCertificacion,
            int torneosArbitrados) {

        super(idUsuario, nombre, correo, password, "ARBITRO", estado);

        this.nivelCertificacion = nivelCertificacion;
        this.torneosArbitrados = torneosArbitrados;
    }

   

    public String getNivelCertificacion() {
        return nivelCertificacion;
    }

    public void setNivelCertificacion(String nivelCertificacion) {
        this.nivelCertificacion = nivelCertificacion;
    }

    public int getTorneosArbitrados() {
        return torneosArbitrados;
    }

    public void setTorneosArbitrados(int torneosArbitrados) {
        this.torneosArbitrados = torneosArbitrados;
    }
}
