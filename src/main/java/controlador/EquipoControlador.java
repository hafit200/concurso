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
import modelo.Equipo;
/**
 *
 * @author LENOVO
 */
public class EquipoControlador {

    public void insertar(Equipo e) {

        try {
            ConexionBDD c = new ConexionBDD();
            Connection con = c.conectar();

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO equipo(codigo_unico,nombre,pais,fecha_fundacion,id_entrenador) "
                    + "VALUES(?,?,?,?,?)"
            );

            ps.setString(1, e.getCodigoUnico());
            ps.setString(2, e.getNombre());
            ps.setString(3, e.getPais());
            ps.setDate(4, Date.valueOf(e.getFechaFundacion()));

            if (e.getEntrenador() != null) {
                ps.setInt(5, e.getEntrenador().getIdUsuario());
            } else {
                ps.setNull(5, Types.INTEGER);
            }

            ps.executeUpdate();
            con.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<String[]> consultar() {

        ArrayList<String[]> lista = new ArrayList<>();

        try {
            ConexionBDD c = new ConexionBDD();
            Connection con = c.conectar();

            PreparedStatement ps = con.prepareStatement(
                    "SELECT e.id_equipo,e.codigo_unico,e.nombre,e.pais,"
                    + "e.fecha_fundacion,u.nombre entrenador "
                    + "FROM equipo e "
                    + "LEFT JOIN usuario u ON e.id_entrenador=u.id_usuario"
            );

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String[] fila = {
                    rs.getString("id_equipo"),
                    rs.getString("codigo_unico"),
                    rs.getString("nombre"),
                    rs.getString("pais"),
                    rs.getString("fecha_fundacion"),
                    rs.getString("entrenador")
                };

                lista.add(fila);
            }

            con.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return lista;
    }

    public void eliminar(int id) {

        try {
            ConexionBDD c = new ConexionBDD();
            Connection con = c.conectar();

            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM equipo WHERE id_equipo=?"
            );

            ps.setInt(1, id);
            ps.executeUpdate();

            con.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}