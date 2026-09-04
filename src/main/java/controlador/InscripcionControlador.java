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
import java.sql.Types;
import java.util.ArrayList;
import modelo.Inscripcion;

/**
 *
 * @author LENOVO
 */
public class InscripcionControlador {

    public void insertar(Inscripcion i) {

        try {
            ConexionBDD c = new ConexionBDD();
            Connection con = c.conectar();

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO inscripcion(id_equipo,id_torneo,fecha_inscripcion,posicion_final) "
                    + "VALUES(?,?,?,?)"
            );

            ps.setInt(1, i.getEquipo().getIdEquipo());
            ps.setInt(2, i.getTorneo().getIdTorneo());
            ps.setDate(3, Date.valueOf(i.getFechaInscripcion()));

            if (i.getPosicionFinal() == null) {
                ps.setNull(4, Types.INTEGER);
            } else {
                ps.setInt(4, i.getPosicionFinal());
            }

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
                    "SELECT i.id_inscripcion,e.nombre equipo,t.nombre torneo,"
                    + "i.fecha_inscripcion,i.posicion_final "
                    + "FROM inscripcion i "
                    + "INNER JOIN equipo e ON i.id_equipo=e.id_equipo "
                    + "INNER JOIN torneo t ON i.id_torneo=t.id_torneo"
            );

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String[] fila = {
                    rs.getString("id_inscripcion"),
                    rs.getString("equipo"),
                    rs.getString("torneo"),
                    rs.getString("fecha_inscripcion"),
                    rs.getString("posicion_final")
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
                    "DELETE FROM inscripcion WHERE id_inscripcion=?"
            );

            ps.setInt(1, id);
            ps.executeUpdate();

            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void actualizarPosicion(int id, int posicion) {

        try {

            ConexionBDD c = new ConexionBDD();
            Connection con = c.conectar();

            PreparedStatement ps = con.prepareStatement(
                    "UPDATE inscripcion "
                    + "SET posicion_final=? "
                    + "WHERE id_inscripcion=?"
            );

            ps.setInt(1, posicion);
            ps.setInt(2, id);

            ps.executeUpdate();

            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
