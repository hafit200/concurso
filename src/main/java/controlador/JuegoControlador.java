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
import modelo.Juego;
/**
 *
 * @author LENOVO
 */
public class JuegoControlador {

    public void insertar(Juego j) {

        try {
            ConexionBDD c = new ConexionBDD();
            Connection con = c.conectar();

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO juego(nombre, genero, modalidad, plataforma, estado) VALUES(?,?,?,?,?)"
            );

            ps.setString(1, j.getNombre());
            ps.setString(2, j.getGenero());
            ps.setString(3, j.getModalidad());
            ps.setString(4, j.getPlataforma());
            ps.setString(5, j.getEstado());

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
                    "SELECT * FROM juego"
            );

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String[] fila = {
                    rs.getString("id_juego"),
                    rs.getString("nombre"),
                    rs.getString("genero"),
                    rs.getString("modalidad"),
                    rs.getString("plataforma"),
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
                    "DELETE FROM juego WHERE id_juego=?"
            );

            ps.setInt(1, id);
            ps.executeUpdate();

            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
