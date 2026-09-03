//package controlador;
//
//import java.sql.CallableStatement;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;
//import vista.VistaInscripcion; 
//
//public class InscripcionControlador {
//
//    private VistaInscripcion vista;
//    private ArrayList<String[]> listaTorneosDisponibles;
//
//    ConexionBDD conectar = new ConexionBDD();
//    Connection conectado = (Connection) conectar.conectar();
//
//    public InscripcionControlador() {}
//
//    public InscripcionControlador(VistaInscripcion vista) {
//        this.vista = vista;
//
//        // 1. Cargar Torneos en cmbTorneo
//        this.listaTorneosDisponibles = obtenerTorneosDisponibles();
//        cargarComboTorneos(this.listaTorneosDisponibles);
//
//        // 2. Listener al cambiar de torneo para actualizar la tabla de patrocinio
//        if (this.vista.getCmbTorneo() != null) {
//            this.vista.getCmbTorneo().addActionListener(e -> cargarPatrociniosPorTorneo());
//        }
//
//        // 3. Listener usando tu getter exacto: getBtnInscribirse()
//        if (this.vista.getBtnInscribirse() != null) {
//            this.vista.getBtnInscribirse().addActionListener(e -> realizarInscripcion());
//        }
//
//        // Carga inicial de patrocinios si hay torneos
//        cargarPatrociniosPorTorneo();
//    }
//
//    public ArrayList<String[]> obtenerTorneosDisponibles() {
//        ArrayList<String[]> lregistros = new ArrayList<>();
//        if (conectado == null) return lregistros;
//
//        String sentenciaSQL = "{CALL sp_obtener_torneos()}";
//
//        try (CallableStatement ejecutar = conectado.prepareCall(sentenciaSQL);
//             ResultSet res = ejecutar.executeQuery()) {
//
//            while (res.next()) {
//                String[] torneo = new String[2];
//                torneo[0] = String.valueOf(res.getInt("id_torneo"));
//                torneo[1] = res.getString("nombre");
//                lregistros.add(torneo);
//            }
//
//        } catch (SQLException e) {
//            System.out.println("Error al obtener torneos disponibles: " + e.getMessage());
//        }
//
//        return lregistros;
//    }
//
//    public void cargarComboTorneos(ArrayList<String[]> lista) {
//        if (vista.getCmbTorneo() != null) {
//            vista.getCmbTorneo().removeAllItems();
//            if (lista != null && !lista.isEmpty()) {
//                for (String[] t : lista) {
//                    vista.getCmbTorneo().addItem(t[0] + " - " + t[1]);
//                }
//            }
//        }
//    }
//
//    public void cargarPatrociniosPorTorneo() {
//        if (vista.getTblPatrocinio() == null) return;
//
//        DefaultTableModel modelo = (DefaultTableModel) vista.getTblPatrocinio().getModel();
//        modelo.setRowCount(0);
//
//        int idxTorneo = vista.getCmbTorneo().getSelectedIndex();
//        if (idxTorneo >= 0 && listaTorneosDisponibles != null && idxTorneo < listaTorneosDisponibles.size()) {
//            int idTorneo = Integer.parseInt(listaTorneosDisponibles.get(idxTorneo)[0]);
//
//            String sentenciaSQL = "{CALL sp_obtener_patrocinios_por_torneo(?)}";
//
//            try (CallableStatement ejecutar = conectado.prepareCall(sentenciaSQL)) {
//                ejecutar.setInt(1, idTorneo);
//                ResultSet res = ejecutar.executeQuery();
//
//                while (res.next()) {
//                    Object[] fila = new Object[2];
//                    fila[0] = res.getString("patrocinador");
//                    fila[1] = res.getDouble("monto");
//                    modelo.addRow(fila);
//                }
//
//            } catch (SQLException e) {
//                System.out.println("Error al cargar tabla de patrocinios: " + e.getMessage());
//            }
//        }
//    }
//
//    public void realizarInscripcion() {
//        int idxTorneo = vista.getCmbTorneo().getSelectedIndex();
//
//        if (idxTorneo < 0) {
//            JOptionPane.showMessageDialog(vista, "Debe seleccionar un torneo.");
//            return;
//        }
//
//        int idTorneo = Integer.parseInt(listaTorneosDisponibles.get(idxTorneo)[0]);
//
//        // Ejecución de la inscripción
//        JOptionPane.showMessageDialog(vista, "Inscripción procesada para el Torneo ID: " + idTorneo);
//    }
//}