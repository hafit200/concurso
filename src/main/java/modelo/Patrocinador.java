/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author LENOVO
 */
public class Patrocinador {

    private int idPatrocinador;
    private String nombreEmpresa;
    private String ruc;
    private String contactoNombre;
    private String contactoCorreo;
    private String contactoTelefono;
    private String estado;

    public Patrocinador() {
    }

    public Patrocinador(int idPatrocinador,
            String nombreEmpresa,
            String ruc,
            String contactoNombre,
            String contactoCorreo,
            String contactoTelefono,
            String estado) {

        this.idPatrocinador = idPatrocinador;
        this.nombreEmpresa = nombreEmpresa;
        this.ruc = ruc;
        this.contactoNombre = contactoNombre;
        this.contactoCorreo = contactoCorreo;
        this.contactoTelefono = contactoTelefono;
        this.estado = estado;
    }

    public int getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(int idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getContactoNombre() {
        return contactoNombre;
    }

    public void setContactoNombre(String contactoNombre) {
        this.contactoNombre = contactoNombre;
    }

    public String getContactoCorreo() {
        return contactoCorreo;
    }

    public void setContactoCorreo(String contactoCorreo) {
        this.contactoCorreo = contactoCorreo;
    }

    public String getContactoTelefono() {
        return contactoTelefono;
    }

    public void setContactoTelefono(String contactoTelefono) {
        this.contactoTelefono = contactoTelefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}