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
import java.util.ArrayList;
import modelo.Patrocinio;

public class PatrocinioControlador {

    public void insertar(Patrocinio p) {

        try {
            ConexionBDD c = new ConexionBDD();
            Connection con = c.conectar();

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO patrocinio(id_patrocinador,id_torneo,monto_aportado) "
                    + "VALUES(?,?,?)"
            );

            ps.setInt(1, p.getPatrocinador().getIdPatrocinador());
            ps.setInt(2, p.getTorneo().getIdTorneo());
            ps.setDouble(3, p.getMontoAportado());

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
                    "SELECT p.id_patrocinio,pa.nombre_empresa,t.nombre torneo,"
                    + "p.monto_aportado "
                    + "FROM patrocinio p "
                    + "INNER JOIN patrocinador pa ON p.id_patrocinador=pa.id_patrocinador "
                    + "INNER JOIN torneo t ON p.id_torneo=t.id_torneo"
            );

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String[] fila = {
                    rs.getString("id_patrocinio"),
                    rs.getString("nombre_empresa"),
                    rs.getString("torneo"),
                    rs.getString("monto_aportado")
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
                    "DELETE FROM patrocinio WHERE id_patrocinio=?"
            );

            ps.setInt(1, id);
            ps.executeUpdate();

            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
