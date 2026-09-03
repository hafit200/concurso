/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author LENOVO
 */
public class Entrenador extends Usuario {

    private Juego juegoEspecialidad;
    private String rolEstrategico;
    private int anosExperiencia;

    public Entrenador() {
        super();
    }

    public Entrenador(int idUsuario,
            String nombre,
            String correo,
            String password,
            String estado,
            Juego juegoEspecialidad,
            String rolEstrategico,
            int anosExperiencia) {

        super(idUsuario, nombre, correo, password, "ENTRENADOR", estado);

        this.juegoEspecialidad = juegoEspecialidad;
        this.rolEstrategico = rolEstrategico;
        this.anosExperiencia = anosExperiencia;
    }

    public Juego getJuegoEspecialidad() {
        return juegoEspecialidad;
    }

    public void setJuegoEspecialidad(Juego juegoEspecialidad) {
        this.juegoEspecialidad = juegoEspecialidad;
    }

    public String getRolEstrategico() {
        return rolEstrategico;
    }

    public void setRolEstrategico(String rolEstrategico) {
        this.rolEstrategico = rolEstrategico;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(int anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }
}