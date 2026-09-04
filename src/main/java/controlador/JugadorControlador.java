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
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Jugador;
/**
 *
 * @author LENOVO
 */
public class JugadorControlador {

    public void insertar(Jugador j) {

        try {
            ConexionBDD c = new ConexionBDD();
            Connection con = c.conectar();

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO usuario(nombre,correo,password,rol,estado) VALUES(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            ps.setString(1, j.getNombre());
            ps.setString(2, j.getCorreo());
            ps.setString(3, j.getPassword());
            ps.setString(4, "JUGADOR");
            ps.setString(5, j.getEstado());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {

                int id = rs.getInt(1);

                PreparedStatement ps2 = con.prepareStatement(
                        "INSERT INTO jugador(id_jugador,nickname,fecha_nacimiento,rol_juego) "
                        + "VALUES(?,?,?,?)"
                );

                ps2.setInt(1, id);
                ps2.setString(2, j.getNickname());
                ps2.setDate(3, Date.valueOf(j.getFechaNacimiento()));
                ps2.setString(4, j.getRolJuego());

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
                    "SELECT u.id_usuario,u.nombre,u.correo,j.nickname,"
                    + "j.fecha_nacimiento,j.rol_juego "
                    + "FROM jugador j "
                    + "INNER JOIN usuario u ON j.id_jugador=u.id_usuario"
            );

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String[] fila = {
                    rs.getString("id_usuario"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("nickname"),
                    rs.getString("fecha_nacimiento"),
                    rs.getString("rol_juego")
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
