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
import modelo.Participacion;
/**
 *
 * @author LENOVO
 */


public class ParticipacionJugadorControlador {

    public void insertar(Participacion p) {

        try {
            ConexionBDD c = new ConexionBDD();
            Connection con = c.conectar();

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO participacion_jugador(id_jugador,id_equipo,id_torneo) "
                    + "VALUES(?,?,?)"
            );

            ps.setInt(1, p.getJugador().getIdUsuario());
            ps.setInt(2, p.getEquipo().getIdEquipo());
            ps.setInt(3, p.getTorneo().getIdTorneo());

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
                    "SELECT p.id_participacion,j.nickname,e.nombre equipo,t.nombre torneo "
                    + "FROM participacion_jugador p "
                    + "INNER JOIN jugador j ON p.id_jugador=j.id_jugador "
                    + "INNER JOIN equipo e ON p.id_equipo=e.id_equipo "
                    + "INNER JOIN torneo t ON p.id_torneo=t.id_torneo"
            );

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String[] fila = {
                    rs.getString("id_participacion"),
                    rs.getString("nickname"),
                    rs.getString("equipo"),
                    rs.getString("torneo")
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
                    "DELETE FROM participacion_jugador WHERE id_participacion=?"
            );

            ps.setInt(1, id);
            ps.executeUpdate();

            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
