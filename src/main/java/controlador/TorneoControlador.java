/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import modelo.Torneo;
/**
 *
 * @author LENOVO
 */


public class TorneoControlador {

    public void insertar(Torneo t) {

        try {
            ConexionBDD c = new ConexionBDD();
            Connection con = c.conectar();

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO torneo(nombre,fecha_inicio,fecha_fin,id_juego,premio_total,estado) "
                    + "VALUES(?,?,?,?,?,?)"
            );

            ps.setString(1, t.getNombre());
            ps.setDate(2, Date.valueOf(t.getFechaInicio()));
            ps.setDate(3, Date.valueOf(t.getFechaFin()));
            ps.setInt(4, t.getJuego().getIdJuego());
            ps.setDouble(5, t.getPremioTotal());
            ps.setString(6, t.getEstado());

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
                    "SELECT t.id_torneo,t.nombre,t.fecha_inicio,t.fecha_fin,"
                    + "j.nombre juego,t.premio_total,t.estado "
                    + "FROM torneo t "
                    + "INNER JOIN juego j ON t.id_juego=j.id_juego"
            );

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String[] fila = {
                    rs.getString("id_torneo"),
                    rs.getString("nombre"),
                    rs.getString("fecha_inicio"),
                    rs.getString("fecha_fin"),
                    rs.getString("juego"),
                    rs.getString("premio_total"),
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
                    "DELETE FROM torneo WHERE id_torneo=?"
            );

            ps.setInt(1, id);
            ps.executeUpdate();

            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
