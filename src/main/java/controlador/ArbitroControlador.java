/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Arbitro;
/**
 *
 * @author LENOVO
 */
public class ArbitroControlador {

    public void insertar(Arbitro a) {

        try {
            ConexionBDD c = new ConexionBDD();
            Connection con = c.conectar();

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO usuario(nombre,correo,password,rol,estado) VALUES(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            ps.setString(1, a.getNombre());
            ps.setString(2, a.getCorreo());
            ps.setString(3, a.getPassword());
            ps.setString(4, "ARBITRO");
            ps.setString(5, a.getEstado());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {

                int id = rs.getInt(1);

                PreparedStatement ps2 = con.prepareStatement(
                        "INSERT INTO arbitro(id_arbitro,nivel_certificacion,torneos_arbitrados) "
                        + "VALUES(?,?,?)"
                );

                ps2.setInt(1, id);
                ps2.setString(2, a.getNivelCertificacion());
                ps2.setInt(3, a.getTorneosArbitrados());

                ps2.executeUpdate();
            }

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
                    "SELECT u.id_usuario,u.nombre,u.correo,"
                    + "a.nivel_certificacion,a.torneos_arbitrados "
                    + "FROM arbitro a "
                    + "INNER JOIN usuario u ON a.id_arbitro=u.id_usuario"
            );

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String[] fila = {
                    rs.getString("id_usuario"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("nivel_certificacion"),
                    rs.getString("torneos_arbitrados")
                };

                lista.add(fila);
            }

            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return lista;
    }
}