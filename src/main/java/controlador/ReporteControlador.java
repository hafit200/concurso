/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author LENOVO
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReporteControlador {

    public ArrayList<String[]> generarReporte(
            LocalDate fechaInicio,
            LocalDate fechaFin,
            int idEquipo) {

        ArrayList<String[]> lista = new ArrayList<>();

        try {

            ConexionBDD bd = new ConexionBDD();
            Connection con = bd.conectar();

            CallableStatement cs
                    = con.prepareCall("{CALL sp_reporte_torneos(?, ?, ?)}");

            cs.setDate(
                    1,
                    java.sql.Date.valueOf(fechaInicio)
            );

            cs.setDate(
                    2,
                    java.sql.Date.valueOf(fechaFin)
            );

            cs.setInt(3, idEquipo);

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {

                System.out.println(
                        "TORNEO: " + rs.getString("torneo")
                );

                String posicion;

                if (rs.getObject("posicion_final") == null) {
                    posicion = "Pendiente";
                } else {
                    posicion = String.valueOf(
                            rs.getInt("posicion_final")
                    );
                }

                String[] fila = {
                    rs.getString("torneo"),
                    rs.getString("juego"),
                    rs.getString("equipo"),
                    rs.getDate("fecha_inscripcion").toString(),
                    posicion
                };

                lista.add(fila);
            }

            rs.close();
            cs.close();
            con.close();

        } catch (SQLException e) {

            System.out.println(
                    "ERROR REPORTE: " + e.getMessage()
            );
        }

        return lista;
    }
}
