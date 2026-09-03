package controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import vista.MenuOrganizador;

public class EquipoControlador {

    private MenuOrganizador vista;
    private ArrayList<String[]> listaEquipos;

    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = (Connection) conectar.conectar();

    public EquipoControlador() {}

    public EquipoControlador(MenuOrganizador vista, TorneoControlador tc) {
        this.vista = vista;

        if (this.vista.getTxtFecha() != null) {
            this.vista.getTxtFecha().setText(LocalDate.now().toString());
        }

        // Listener: al seleccionar un torneo en la interfaz
        this.vista.getCmbTorneo().addActionListener(e -> {
            int index = this.vista.getCmbTorneo().getSelectedIndex();
            ArrayList<String[]> torneos = tc.getListaTorneos();

            if (index >= 0 && torneos != null && index < torneos.size()) {
                int idTorneo = Integer.parseInt(torneos.get(index)[0]);
                actualizarListaEquipos(idTorneo);
            }
        });
    }

    public void actualizarListaEquipos(int idTorneo) {
        this.listaEquipos = obtenerEquiposPorTorneo(idTorneo);
        cargarEquipos(this.listaEquipos);
    }

    public ArrayList<String[]> obtenerEquiposPorTorneo(int idTorneo) {
        ArrayList<String[]> lregistros = new ArrayList<>();
        if (conectado == null) return lregistros;

        String sentenciaSQL = "{CALL sp_obtener_equipos_por_torneo(?)}";

        try (CallableStatement ejecutar = conectado.prepareCall(sentenciaSQL)) {
            ejecutar.setInt(1, idTorneo);
            ResultSet res = ejecutar.executeQuery();

            while (res.next()) {
                String[] equipo = new String[4];
                equipo[0] = String.valueOf(res.getInt("id_equipo"));
                equipo[1] = res.getString("codigo");
                equipo[2] = res.getString("nombre");
                equipo[3] = res.getString("pais");

                lregistros.add(equipo);
            }

        } catch (SQLException e) {
            System.out.println("Error al ejecutar sp_obtener_equipos_por_torneo: " + e.getMessage());
        }

        return lregistros;
    }

    public void cargarEquipos(ArrayList<String[]> lE) {
        if (vista.getCmbEquipo() != null) {
            vista.getCmbEquipo().removeAllItems();

            if (lE != null && !lE.isEmpty()) {
                for (String[] equipo : lE) {
                    vista.getCmbEquipo().addItem(equipo[1] + " - " + equipo[2]);
                }
            }
        }
    }

    public ArrayList<String[]> getListaEquipos() {
        return listaEquipos;
    }
}