package controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import vista.MenuOrganizador;

public class TorneoControlador {

    private MenuOrganizador vista;
    private ArrayList<String[]> listaTorneos;

    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = (Connection) conectar.conectar();

    public TorneoControlador() {}

    public TorneoControlador(MenuOrganizador vista) {
        this.vista = vista;
        this.listaTorneos = obtenerTorneos();
        cargarTorneos(this.listaTorneos);
    }

    public ArrayList<String[]> obtenerTorneos() {
        ArrayList<String[]> lregistros = new ArrayList<>();
        if (conectado == null) return lregistros;

        String sentenciaSQL = "{CALL sp_obtener_torneos()}";

        try (CallableStatement ejecutar = conectado.prepareCall(sentenciaSQL);
             ResultSet res = ejecutar.executeQuery()) {

            while (res.next()) {
                String[] torneo = new String[2];
                torneo[0] = String.valueOf(res.getInt("id_torneo"));
                torneo[1] = res.getString("nombre");

                lregistros.add(torneo);
            }

        } catch (SQLException e) {
            System.out.println("Error al ejecutar sp_obtener_torneos: " + e.getMessage());
        }

        return lregistros;
    }

    public void cargarTorneos(ArrayList<String[]> lT) {
        if (vista.getCmbTorneo() != null) {
            vista.getCmbTorneo().removeAllItems();

            if (lT != null && !lT.isEmpty()) {
                for (String[] torneo : lT) {
                    vista.getCmbTorneo().addItem(torneo[0] + " - " + torneo[1]);
                }
            }
        }
    }

    public ArrayList<String[]> getListaTorneos() {
        return listaTorneos;
    }
}