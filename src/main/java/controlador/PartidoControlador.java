/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author LENOVO
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Types;
import java.util.ArrayList;
import modelo.Partido;

public class PartidoControlador {

    public void insertar(Partido p) {

        try {
            ConexionBDD c = new ConexionBDD();
            Connection con = c.conectar();

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO partido(id_ronda,id_equipo1,id_equipo2,fecha,hora,"
                    + "marcador_equipo1,marcador_equipo2,id_arbitro,id_sede) "
                    + "VALUES(?,?,?,?,?,?,?,?,?)"
            );

            ps.setInt(1, p.getRonda().getIdRonda());
            ps.setInt(2, p.getEquipo1().getIdEquipo());
            ps.setInt(3, p.getEquipo2().getIdEquipo());
            ps.setDate(4, Date.valueOf(p.getFecha()));
            ps.setTime(5, Time.valueOf(p.getHora()));

            if (p.getMarcadorEquipo1() == null) {
                ps.setNull(6, Types.INTEGER);
            } else {
                ps.setInt(6, p.getMarcadorEquipo1());
            }

            if (p.getMarcadorEquipo2() == null) {
                ps.setNull(7, Types.INTEGER);
            } else {
                ps.setInt(7, p.getMarcadorEquipo2());
            }

            ps.setInt(8, p.getArbitro().getIdUsuario());
            ps.setInt(9, p.getSede().getIdSede());

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
                    "SELECT p.id_partido,e1.nombre equipo1,e2.nombre equipo2,"
                    + "p.fecha,p.hora,p.marcador_equipo1,p.marcador_equipo2,"
                    + "u.nombre arbitro,s.nombre sede "
                    + "FROM partido p "
                    + "INNER JOIN equipo e1 ON p.id_equipo1=e1.id_equipo "
                    + "INNER JOIN equipo e2 ON p.id_equipo2=e2.id_equipo "
                    + "INNER JOIN arbitro a ON p.id_arbitro=a.id_arbitro "
                    + "INNER JOIN usuario u ON a.id_arbitro=u.id_usuario "
                    + "INNER JOIN sede s ON p.id_sede=s.id_sede"
            );

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String[] fila = {
                    rs.getString("id_partido"),
                    rs.getString("equipo1"),
                    rs.getString("equipo2"),
                    rs.getString("fecha"),
                    rs.getString("hora"),
                    rs.getString("marcador_equipo1"),
                    rs.getString("marcador_equipo2"),
                    rs.getString("arbitro"),
                    rs.getString("sede")
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
                    "DELETE FROM partido WHERE id_partido=?"
            );

            ps.setInt(1, id);
            ps.executeUpdate();

            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
