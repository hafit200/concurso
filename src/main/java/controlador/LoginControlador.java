/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author LENOVO
 */

import modelo.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginControlador {

    private Connection conexion;

    public LoginControlador() {

        ConexionBDD bd = new ConexionBDD();
        conexion = bd.conectar();
    }

    public Usuario iniciarSesion(String correo, String password) {

        Usuario usuario = null;

        try {

            CallableStatement cs = conexion.prepareCall(
                    "{CALL sp_login(?, ?)}"
            );

            cs.setString(1, correo);
            cs.setString(2, password);

            ResultSet rs = cs.executeQuery();

            if (rs.next()) {

                usuario = new Usuario();

                usuario.setIdUsuario(
                        rs.getInt("id_usuario")
                );

                usuario.setNombre(
                        rs.getString("nombre")
                );

                usuario.setCorreo(
                        rs.getString("correo")
                );

                usuario.setRol(
                        rs.getString("rol")
                );

                usuario.setEstado(
                        rs.getString("estado")
                );
            }

            rs.close();
            cs.close();

        } catch (SQLException e) {

            System.out.println(
                    "ERROR EN LOGIN: "
                    + e.getMessage()
            );
        }

        return usuario;
    }
}