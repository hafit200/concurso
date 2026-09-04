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
import modelo.Entrenador;

/**
 *
 * @author LENOVO
 */

public class EntrenadorControlador {

    public boolean insertar(Entrenador e) {

        try {

            ConexionBDD bd = new ConexionBDD();
            Connection con = bd.conectar();

            if (con == null) {
                System.out.println("CONEXION NULL");
                return false;
            }

            System.out.println("INSERTANDO USUARIO");

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO usuario(nombre,correo,password,rol,estado) "
                    + "VALUES(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            ps.setString(1, e.getNombre());
            ps.setString(2, e.getCorreo());
            ps.setString(3, e.getPassword());
            ps.setString(4, "ENTRENADOR");
            ps.setString(5, e.getEstado());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {

                int id = rs.getInt(1);

                System.out.println("ID CREADO: " + id);

                PreparedStatement ps2 = con.prepareStatement(
                        "INSERT INTO entrenador"
                        + "(id_entrenador,rol_estrategico,anos_experiencia) "
                        + "VALUES(?,?,?)"
                );

                ps2.setInt(1, id);
                ps2.setString(2, e.getRolEstrategico());
                ps2.setInt(3, e.getAnosExperiencia());

                ps2.executeUpdate();

                System.out.println("ENTRENADOR INSERTADO");
            }

            con.close();

            return true;

        } catch (SQLException ex) {

            System.out.println("ERROR SQL:");
            System.out.println(ex.getMessage());

            return false;
        }
    }

    public ArrayList<String[]> consultar() {

        ArrayList<String[]> lista = new ArrayList<>();

        try {
            ConexionBDD c = new ConexionBDD();
            Connection con = c.conectar();

            PreparedStatement ps = con.prepareStatement(
                    "SELECT u.id_usuario,u.nombre,u.correo,"
                    + "e.rol_estrategico,e.anos_experiencia "
                    + "FROM entrenador e "
                    + "INNER JOIN usuario u ON e.id_entrenador=u.id_usuario"
            );

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String[] fila = {
                    rs.getString("id_usuario"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("rol_estrategico"),
                    rs.getString("anos_experiencia")
                };

                lista.add(fila);
            }

            con.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return lista;
    }
}
