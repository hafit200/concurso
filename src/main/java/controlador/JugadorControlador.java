package controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.MenuOrganizador;

public class JugadorControlador {

    private MenuOrganizador vista;
    private ArrayList<String[]> listaJugadores;

    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = (Connection) conectar.conectar();

    public JugadorControlador() {}

    public JugadorControlador(MenuOrganizador vista, TorneoControlador tc, EquipoControlador ec) {
        this.vista = vista;

        // 1. Cargar combo de Jugadores vía SP
        this.listaJugadores = obtenerJugadores();
        cargarJugadores(this.listaJugadores);

        // 2. Mapear el rol_juego al cambiar de jugador
        this.vista.getCmbJugador().addActionListener(e -> {
            int index = this.vista.getCmbJugador().getSelectedIndex();
            if (index >= 0 && listaJugadores != null && index < listaJugadores.size()) {
                String[] seleccionado = listaJugadores.get(index);
                this.vista.getTxtRol().setText(seleccionado[3]);
            }
        });

        // 3. Listener: Al cambiar de Torneo o Equipo, refrescar la JTable de participantes
        this.vista.getCmbEquipo().addActionListener(e -> refrescarTabla(tc, ec));
        this.vista.getCmbTorneo().addActionListener(e -> refrescarTabla(tc, ec));

        // Refrescar la tabla al arrancar la ventana
        refrescarTabla(tc, ec);
    }

    public ArrayList<String[]> obtenerJugadores() {
        ArrayList<String[]> lregistros = new ArrayList<>();
        if (conectado == null) return lregistros;

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
            System.out.println("Error al ejecutar sp_obtener_jugadores: " + e.getMessage());
        }

        return lregistros;
    }

    public void cargarJugadores(ArrayList<String[]> lJ) {
        if (vista.getCmbJugador() != null) {
            vista.getCmbJugador().removeAllItems();

            if (lJ != null && !lJ.isEmpty()) {
                for (String[] jugador : lJ) {
                    vista.getCmbJugador().addItem(jugador[2] + " (" + jugador[1] + ")");
                }
            }
        }
    }

    // Refresca la JTable con los jugadores participantes del Torneo y Equipo seleccionados
    public void refrescarTabla(TorneoControlador tc, EquipoControlador ec) {
        if (vista.getTblParticipantes() == null) return;

        DefaultTableModel modelo = (DefaultTableModel) vista.getTblParticipantes().getModel();
        modelo.setRowCount(0);

        int idxTorneo = vista.getCmbTorneo().getSelectedIndex();
        int idxEquipo = vista.getCmbEquipo().getSelectedIndex();

        ArrayList<String[]> torneos = tc.getListaTorneos();
        ArrayList<String[]> equipos = ec.getListaEquipos();

        // Validar que ambos combos tengan una opción válida seleccionada
        if (idxTorneo >= 0 && idxEquipo >= 0 && torneos != null && equipos != null 
                && idxTorneo < torneos.size() && idxEquipo < equipos.size()) {

            int idTorneo = Integer.parseInt(torneos.get(idxTorneo)[0]);
            int idEquipo = Integer.parseInt(equipos.get(idxEquipo)[0]);

            String sentenciaSQL = "{CALL sp_obtener_participaciones_por_equipo_torneo(?, ?)}";

            try (CallableStatement ejecutar = conectado.prepareCall(sentenciaSQL)) {

                ejecutar.setInt(1, idTorneo);
                ejecutar.setInt(2, idEquipo);

                ResultSet res = ejecutar.executeQuery();

                while (res.next()) {
                    Object[] fila = new Object[4];
                    fila[0] = res.getString("nombre");
                    fila[1] = res.getString("nickname");
                    fila[2] = res.getString("equipo");
                    fila[3] = res.getString("rol");

                    modelo.addRow(fila);
                }

            } catch (SQLException e) {
                System.out.println("Error al cargar la tabla de participantes: " + e.getMessage());
            }
        }
    }

    // Método invocado por el botón "AÑADIR PARTICIPANTES"
    public void registrarParticipacion(TorneoControlador tc, EquipoControlador ec) {
        int idxTorneo = vista.getCmbTorneo().getSelectedIndex();
        int idxEquipo = vista.getCmbEquipo().getSelectedIndex();
        int idxJugador = vista.getCmbJugador().getSelectedIndex();

        if (idxTorneo < 0 || idxEquipo < 0 || idxJugador < 0) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar Torneo, Equipo y Jugador.");
            return;
        }

        int idTorneo = Integer.parseInt(tc.getListaTorneos().get(idxTorneo)[0]);
        int idEquipo = Integer.parseInt(ec.getListaEquipos().get(idxEquipo)[0]);
        int idJugador = Integer.parseInt(listaJugadores.get(idxJugador)[0]);

        String sentenciaSQL = "{CALL sp_registrar_participacion(?, ?, ?)}";

        try (CallableStatement ejecutar = conectado.prepareCall(sentenciaSQL)) {
            ejecutar.setInt(1, idJugador);
            ejecutar.setInt(2, idEquipo);
            ejecutar.setInt(3, idTorneo);

            ejecutar.executeUpdate();
            JOptionPane.showMessageDialog(vista, "¡Jugador añadido al equipo exitosamente!");

            // Actualizar la tabla inmediatamente
            refrescarTabla(tc, ec);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(vista, "Error o Regla Violada: El jugador ya pertenece a un equipo en este torneo.");
            System.out.println("Error al registrar participacion: " + e.getMessage());
        }
    }
}