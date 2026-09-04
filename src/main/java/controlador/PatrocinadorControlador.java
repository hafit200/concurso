/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Patrocinador;
/**
 *
 * @author LENOVO
 */


public class PatrocinadorControlador {

    public void insertar(Patrocinador p) {

        try {
            ConexionBDD c = new ConexionBDD();
            Connection con = c.conectar();

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO patrocinador(nombre_empresa,ruc,contacto_nombre,"
                    + "contacto_correo,contacto_telefono,estado) "
                    + "VALUES(?,?,?,?,?,?)"
            );

            ps.setString(1, p.getNombreEmpresa());
            ps.setString(2, p.getRuc());
            ps.setString(3, p.getContactoNombre());
            ps.setString(4, p.getContactoCorreo());
            ps.setString(5, p.getContactoTelefono());
            ps.setString(6, p.getEstado());

            ps.executeUpdate();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<String[]> consultar() {

        ArrayList<String[]> lista = new ArrayList<>();

        try {
            ConexionBDD c = new ConexionBDD();
            Connection con = c.conectar();

            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM patrocinador"
            );

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String[] fila = {
                    rs.getString("id_patrocinador"),
                    rs.getString("nombre_empresa"),
                    rs.getString("ruc"),
                    rs.getString("contacto_nombre"),
                    rs.getString("contacto_correo"),
                    rs.getString("contacto_telefono"),
                    rs.getString("estado")
                };

                lista.add(fila);
            }

            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return lista;
    }

    public void eliminar(int id) {

        try {
            ConexionBDD c = new ConexionBDD();
            Connection con = c.conectar();

            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM patrocinador WHERE id_patrocinador=?"
            );

            ps.setInt(1, id);
            ps.executeUpdate();

            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}