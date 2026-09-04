/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;



import java.sql.Connection;
import java.sql.SQLException;



import java.sql.DriverManager;

/**
 *
 * @author Usuario
 */
public class ConexionBDD {

    // ATRIBUTO
    java.sql.Connection conexion;

    public java.sql.Connection conectar() {

        try {

            // Driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Parámetros de conexión
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/torneo_esports?autoReconnect=true&useSSL=false",
                    "root",
                    "admin"
            );

            System.out.println("CONECTADO");

        } catch (ClassNotFoundException | SQLException e) {

    System.out.println("ERROR DE CONEXION");
    e.printStackTrace();
}

        return conexion;
    }

    
}