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

public class Jugador extends Usuario {

    private String nickname;
    private LocalDate fechaNacimiento;
    private String rolJuego;

    public Jugador() {
        super();
    }

    public Jugador(int idUsuario,
            String nombre,
            String correo,
            String password,
            String estado,
            String nickname,
            LocalDate fechaNacimiento,
            String rolJuego,
            Juego juegoEspecialidad) {

        super(idUsuario, nombre, correo, password, "JUGADOR", estado);

        this.nickname = nickname;
        this.fechaNacimiento = fechaNacimiento;
        this.rolJuego = rolJuego;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getRolJuego() {
        return rolJuego;
    }

    public void setRolJuego(String rolJuego) {
        this.rolJuego = rolJuego;
    }

   
}
