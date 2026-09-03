package vista;

import controlador.EquipoControlador;
import controlador.JugadorControlador;
import controlador.TorneoControlador;

public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            // 1. Instanciar la vista principal
            MenuOrganizador mo = new MenuOrganizador();

            // 2. Crear controladores
            TorneoControlador tc = new TorneoControlador(mo);
            EquipoControlador ec = new EquipoControlador(mo, tc);
            JugadorControlador jc = new JugadorControlador(mo, tc, ec);

            // 3. EVENTO CLAVE: Forzar la sincronización inicial de combos y tabla
            if (tc.getListaTorneos() != null && !tc.getListaTorneos().isEmpty()) {
                mo.getCmbTorneo().setSelectedIndex(0);
                int primerIdTorneo = Integer.parseInt(tc.getListaTorneos().get(0)[0]);
                
                // Carga los equipos del primer torneo
                ec.actualizarListaEquipos(primerIdTorneo);
                
                // Refresca la tabla de participantes
                jc.refrescarTabla(tc, ec);
            }

            // 4. Acción del botón para añadir nuevos participantes
            mo.getBtnAñadirJugador().addActionListener(e -> {
                jc.registrarParticipacion(tc, ec);
            });

            // 5. Mostrar pantalla centrado
            mo.setLocationRelativeTo(null);
            mo.setVisible(true);
        });
    }
}