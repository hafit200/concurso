package controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import vista.MenuOrganizador;

public class OrganizadorControlador {

    private MenuOrganizador vista;
    private ArrayList<String[]> listaJugadores;

    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = (Connection) conectar.conectar();

    public OrganizadorControlador() {}

    public OrganizadorControlador(MenuOrganizador vista) {
        this.vista = vista;
        this.listaJugadores = obtenerJugadores();
        cargarJugadores(this.listaJugadores);

        // Evento Listener: Mapeo de campos de Jugadores
        this.vista.getCmbJugador().addActionListener(e -> {
            int index = this.vista.getCmbJugador().getSelectedIndex();
            if (index >= 0 && listaJugadores != null && !listaJugadores.isEmpty()) {
                String[] seleccionado = listaJugadores.get(index);
                this.vista.getTxtRol().setText(seleccionado[3]); // rol_juego
            }
        });
    }

    // Consulta de Jugadores únicamente mediante Stored Procedure
    public ArrayList<String[]> obtenerJugadores() {
        ArrayList<String[]> lregistros = new ArrayList<>();
        String sentenciaSQL = "{CALL sp_obtener_jugadores()}";

        try (CallableStatement ejecutar = conectado.prepareCall(sentenciaSQL);
             ResultSet res = ejecutar.executeQuery()) {

            while (res.next()) {
                String[] jugador = new String[4];
                jugador[0] = String.valueOf(res.getInt("id_jugador"));
                jugador[1] = res.getString("nombre");
                jugador[2] = res.getString("nickname");
                jugador[3] = res.getString("rol_juego");

                lregistros.add(jugador);
            }

        } catch (SQLException e) {
            System.out.println("Error al ejecutar el SP sp_obtener_jugadores: " + e.getMessage());
        }

        return lregistros;
    }

    public void cargarJugadores(ArrayList<String[]> lJ) {
        vista.getCmbJugador().removeAllItems();

        if (lJ != null && !lJ.isEmpty()) {
            for (String[] jugador : lJ) {
                vista.getCmbJugador().addItem(jugador[2] + " (" + jugador[1] + ")");
            }
        }
    }

    public ArrayList<String[]> getListaJugadores() {
        return listaJugadores;
    }
}