/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.TorneoControlador;
import controlador.InscripcionControlador;
import controlador.RondaControlador;
import controlador.JuegoControlador;
import controlador.EquipoControlador;
import controlador.ParticipacionJugadorControlador;

import modelo.Torneo;
import modelo.Inscripcion;
import modelo.Ronda;
import modelo.Juego;
import modelo.Equipo;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Jugador;
import modelo.Participacion;

import java.util.ArrayList;

import controlador.JugadorControlador;

import controlador.JugadorControlador;
import modelo.Usuario;

/**
 *
 * @author LENOVO
 */
public class GestionTorneosVista extends javax.swing.JFrame {

    private TorneoControlador torneoControlador = new TorneoControlador();
    private InscripcionControlador inscripcionControlador = new InscripcionControlador();
    private RondaControlador rondaControlador = new RondaControlador();
    private JuegoControlador juegoControlador = new JuegoControlador();
    private EquipoControlador equipoControlador = new EquipoControlador();
    private ParticipacionJugadorControlador participacionJugadorControlador
            = new ParticipacionJugadorControlador();

    private DefaultTableModel modeloParticipaciones;
    private DefaultTableModel modeloTorneos;
    private DefaultTableModel modeloInscripciones;
    private DefaultTableModel modeloRondas;
    private Usuario usuario;

    /**
     * Creates new form GestionTorneosVista
     */
    public GestionTorneosVista(Usuario usuario) {

        initComponents();

        this.usuario = usuario;

        setLocationRelativeTo(null);

        modeloTorneos = (DefaultTableModel) tblTorneos.getModel();
        modeloInscripciones = (DefaultTableModel) tblInscripciones.getModel();
        modeloRondas = (DefaultTableModel) tblRondas.getModel();
        modeloParticipaciones = (DefaultTableModel) tblParticipaciones.getModel();

        cargarParticipaciones();
        cargarComboJugadores();
        cargarComboEquiposParticipacion();
        cargarComboTorneosParticipacion();

        cargarTorneos();
        cargarInscripciones();
        cargarRondas();

        cargarComboJuegos();
        cargarComboEquipos();
        cargarComboTorneos();
    }

    public void cargarTorneos() {

        modeloTorneos.setRowCount(0);

        ArrayList<String[]> lista = torneoControlador.consultar();

        for (String[] t : lista) {
            modeloTorneos.addRow(t);
        }
    }

    public void cargarInscripciones() {

        modeloInscripciones.setRowCount(0);

        ArrayList<String[]> lista = inscripcionControlador.consultar();

        for (String[] i : lista) {
            modeloInscripciones.addRow(i);
        }
    }

    public void cargarRondas() {

        modeloRondas.setRowCount(0);

        ArrayList<String[]> lista = rondaControlador.consultar();

        for (String[] r : lista) {
            modeloRondas.addRow(r);
        }
    }

    public void cargarComboJuegos() {

        cmbJuego.removeAllItems();

        ArrayList<String[]> lista = juegoControlador.consultar();

        for (String[] j : lista) {

            cmbJuego.addItem(
                    j[0] + " - " + j[1]
            );
        }
    }

    public void cargarComboEquipos() {

        cmbEquipoInscripcion.removeAllItems();

        ArrayList<String[]> lista = equipoControlador.consultar();

        for (String[] e : lista) {

            cmbEquipoInscripcion.addItem(
                    e[0] + " - " + e[2]
            );
        }
    }

    public void cargarComboTorneos() {

        cmbTorneoInscripcion.removeAllItems();
        cmbTorneoRonda.removeAllItems();

        ArrayList<String[]> lista = torneoControlador.consultar();

        for (String[] t : lista) {

            String dato = t[0] + " - " + t[1];

            cmbTorneoInscripcion.addItem(dato);
            cmbTorneoRonda.addItem(dato);
        }
    }

    public void limpiarTorneo() {

        txtNombreTorneo.setText("");
        txtFechaInicio.setText("");
        txtFechaFin.setText("");
        txtPremio.setText("");

        if (cmbJuego.getItemCount() > 0) {
            cmbJuego.setSelectedIndex(0);
        }
    }

    public void limpiarInscripcion() {

        txtFechaInscripcion.setText("");
        txtPosicionFinal.setText("");

        if (cmbEquipoInscripcion.getItemCount() > 0) {
            cmbEquipoInscripcion.setSelectedIndex(0);
        }

        if (cmbTorneoInscripcion.getItemCount() > 0) {
            cmbTorneoInscripcion.setSelectedIndex(0);
        }
    }

    public void limpiarRonda() {

        txtNumeroRonda.setText("");
        cmbNombreRonda.setSelectedIndex(0);

        if (cmbTorneoRonda.getItemCount() > 0) {
            cmbTorneoRonda.setSelectedIndex(0);
        }
    }

    public void cargarParticipaciones() {

        modeloParticipaciones.setRowCount(0);

        ArrayList<String[]> lista
                = participacionJugadorControlador.consultar();

        for (String[] p : lista) {

            modeloParticipaciones.addRow(p);
        }
    }

    public void cargarComboJugadores() {

        cmbJugadorParticipacion.removeAllItems();

        JugadorControlador controlador
                = new JugadorControlador();

        ArrayList<String[]> lista
                = controlador.consultar();

        for (String[] j : lista) {

            cmbJugadorParticipacion.addItem(
                    j[0] + " - " + j[3]
            );
        }
    }

    public void cargarComboEquiposParticipacion() {

        cmbEquipoParticipacion.removeAllItems();

        EquipoControlador controlador
                = new EquipoControlador();

        ArrayList<String[]> lista
                = controlador.consultar();

        for (String[] e : lista) {

            cmbEquipoParticipacion.addItem(
                    e[0] + " - " + e[2]
            );
        }
    }

    public void cargarComboTorneosParticipacion() {

        cmbTorneoParticipacion.removeAllItems();

        TorneoControlador controlador
                = new TorneoControlador();

        ArrayList<String[]> lista
                = controlador.consultar();

        for (String[] t : lista) {

            cmbTorneoParticipacion.addItem(
                    t[0] + " - " + t[1]
            );
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtFechaInicio = new javax.swing.JTextField();
        txtFechaFin = new javax.swing.JTextField();
        txtPremio = new javax.swing.JTextField();
        cmbJuego = new javax.swing.JComboBox<>();
        btnGuardarTorneo = new javax.swing.JButton();
        btnEliminarTorneo = new javax.swing.JButton();
        btnLimpiarTorneo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTorneos = new javax.swing.JTable();
        txtNombreTorneo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbEquipoInscripcion = new javax.swing.JComboBox<>();
        cmbTorneoInscripcion = new javax.swing.JComboBox<>();
        txtFechaInscripcion = new javax.swing.JTextField();
        txtPosicionFinal = new javax.swing.JTextField();
        btnInscribir = new javax.swing.JButton();
        btnActualizarPosicion = new javax.swing.JButton();
        btnEliminarInscripciones = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblInscripciones = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cmbTorneoRonda = new javax.swing.JComboBox<>();
        txtNumeroRonda = new javax.swing.JTextField();
        txtGuardarRonda = new javax.swing.JButton();
        btnEliminarRonda = new javax.swing.JButton();
        btnLimpiarRonda = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRondas = new javax.swing.JTable();
        cmbNombreRonda = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cmbJugadorParticipacion = new javax.swing.JComboBox<>();
        cmbEquipoParticipacion = new javax.swing.JComboBox<>();
        cmbTorneoParticipacion = new javax.swing.JComboBox<>();
        btnAsignarJugador = new javax.swing.JButton();
        btnEliminarParticipacion = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblParticipaciones = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Gestion de Torneos");

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jLabel2.setText("Fecha Inicio.");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Fecha Fin:");

        jLabel5.setText("Premio:");

        jLabel6.setText("Juego:");

        cmbJuego.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnGuardarTorneo.setText("Guardar");
        btnGuardarTorneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarTorneoActionPerformed(evt);
            }
        });

        btnEliminarTorneo.setText("Eliminar");
        btnEliminarTorneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTorneoActionPerformed(evt);
            }
        });

        btnLimpiarTorneo.setText("Limpiar");
        btnLimpiarTorneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarTorneoActionPerformed(evt);
            }
        });

        tblTorneos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Fecha Inicio", "Fecha FIn", "Juego", "Premio"
            }
        ));
        jScrollPane1.setViewportView(tblTorneos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnGuardarTorneo)
                                .addGap(6, 6, 6)))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPremio, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                .addComponent(txtFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                .addComponent(cmbJuego, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnEliminarTorneo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLimpiarTorneo)))
                            .addComponent(txtNombreTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtNombreTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(cmbJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtPremio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarTorneo)
                    .addComponent(btnEliminarTorneo)
                    .addComponent(btnLimpiarTorneo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("TORNEOS", jPanel1);

        jLabel7.setText("Equipo:");

        jLabel8.setText("Torneo:");

        jLabel9.setText("Fecha Inscripcion:");

        jLabel10.setText("Posicion Final:");

        cmbEquipoInscripcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbTorneoInscripcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnInscribir.setText("Inscribir");
        btnInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscribirActionPerformed(evt);
            }
        });

        btnActualizarPosicion.setText("Actualizar Posicion");
        btnActualizarPosicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarPosicionActionPerformed(evt);
            }
        });

        btnEliminarInscripciones.setText("Eliminar");
        btnEliminarInscripciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarInscripcionesActionPerformed(evt);
            }
        });

        tblInscripciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Equipo", "Torneo", "Fecha", "Posicion"
            }
        ));
        jScrollPane2.setViewportView(tblInscripciones);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnInscribir))
                        .addGap(71, 71, 71)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnActualizarPosicion)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarInscripciones))
                            .addComponent(cmbEquipoInscripcion, 0, 223, Short.MAX_VALUE)
                            .addComponent(cmbTorneoInscripcion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPosicionFinal)
                            .addComponent(txtFechaInscripcion))
                        .addGap(139, 139, 139))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbEquipoInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbTorneoInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFechaInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtPosicionFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInscribir)
                    .addComponent(btnActualizarPosicion)
                    .addComponent(btnEliminarInscripciones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        jTabbedPane1.addTab("INSCRIPCIONES", jPanel2);

        jLabel11.setText("Torneo:");

        jLabel12.setText("Numero Ronda:");

        jLabel13.setText("Nombre Ronda:");

        cmbTorneoRonda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtGuardarRonda.setText("Guardar");
        txtGuardarRonda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGuardarRondaActionPerformed(evt);
            }
        });

        btnEliminarRonda.setText("Eliminar");
        btnEliminarRonda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarRondaActionPerformed(evt);
            }
        });

        btnLimpiarRonda.setText("Limpiar");
        btnLimpiarRonda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarRondaActionPerformed(evt);
            }
        });

        tblRondas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Numero", "Nombre", "Torneo"
            }
        ));
        jScrollPane3.setViewportView(tblRondas);

        cmbNombreRonda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Octavos", "Cuartos", "Semifinal", "Final" }));
        cmbNombreRonda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNombreRondaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGuardarRonda))
                        .addGap(104, 104, 104)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnEliminarRonda)
                                .addGap(35, 35, 35)
                                .addComponent(btnLimpiarRonda))
                            .addComponent(txtNumeroRonda)
                            .addComponent(cmbTorneoRonda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbNombreRonda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cmbTorneoRonda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumeroRonda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cmbNombreRonda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGuardarRonda)
                    .addComponent(btnEliminarRonda)
                    .addComponent(btnLimpiarRonda))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("RONDAS", jPanel3);

        jLabel14.setText("Jugador:");

        jLabel15.setText("Equipo:");

        jLabel16.setText("Torneo:");

        cmbJugadorParticipacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbEquipoParticipacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbTorneoParticipacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAsignarJugador.setText("Asignar");
        btnAsignarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarJugadorActionPerformed(evt);
            }
        });

        btnEliminarParticipacion.setText("Eliminar");

        tblParticipaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Jugador", "Equipo", "Torneo"
            }
        ));
        jScrollPane4.setViewportView(tblParticipaciones);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(btnAsignarJugador)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminarParticipacion))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addGap(64, 64, 64)
                            .addComponent(cmbJugadorParticipacion, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(66, 66, 66)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbEquipoParticipacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbTorneoParticipacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cmbJugadorParticipacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cmbEquipoParticipacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cmbTorneoParticipacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAsignarJugador)
                    .addComponent(btnEliminarParticipacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
        );

        jTabbedPane1.addTab("JUGADORES", jPanel4);

        btnRegresar.setText("←");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1)))
                .addGap(550, 550, 550))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnRegresar))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarTorneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarTorneoActionPerformed
        Torneo torneo = new Torneo();

        torneo.setNombre(
                txtNombreTorneo.getText()
        );

        torneo.setFechaInicio(
                LocalDate.parse(
                        txtFechaInicio.getText()
                )
        );

        torneo.setFechaFin(
                LocalDate.parse(
                        txtFechaFin.getText()
                )
        );

        String datoJuego = cmbJuego
                .getSelectedItem()
                .toString();

        int idJuego = Integer.parseInt(
                datoJuego.split(" - ")[0]
        );

        Juego juego = new Juego();

        juego.setIdJuego(idJuego);

        torneo.setJuego(juego);

        torneo.setPremioTotal(
                Double.parseDouble(
                        txtPremio.getText()
                )
        );

        torneo.setEstado("ACTIVO");

        torneoControlador.insertar(torneo);

        JOptionPane.showMessageDialog(
                this,
                "Torneo guardado"
        );

        cargarTorneos();
        cargarComboTorneos();
        limpiarTorneo();        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarTorneoActionPerformed

    private void btnEliminarTorneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTorneoActionPerformed
        int fila = tblTorneos.getSelectedRow();

        if (fila == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione un torneo"
            );

        } else {

            int id = Integer.parseInt(
                    tblTorneos.getValueAt(
                            fila,
                            0
                    ).toString()
            );

            torneoControlador.eliminar(id);

            JOptionPane.showMessageDialog(
                    this,
                    "Torneo eliminado"
            );

            cargarTorneos();
            cargarComboTorneos();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarTorneoActionPerformed

    private void btnLimpiarTorneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarTorneoActionPerformed
        limpiarTorneo();        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarTorneoActionPerformed

    private void btnInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscribirActionPerformed
        Inscripcion inscripcion = new Inscripcion();

        String datoEquipo = cmbEquipoInscripcion
                .getSelectedItem()
                .toString();

        int idEquipo = Integer.parseInt(
                datoEquipo.split(" - ")[0]
        );

        Equipo equipo = new Equipo();

        equipo.setIdEquipo(idEquipo);

        inscripcion.setEquipo(equipo);

        String datoTorneo = cmbTorneoInscripcion
                .getSelectedItem()
                .toString();

        int idTorneo = Integer.parseInt(
                datoTorneo.split(" - ")[0]
        );

        Torneo torneo = new Torneo();

        torneo.setIdTorneo(idTorneo);

        inscripcion.setTorneo(torneo);

        inscripcion.setFechaInscripcion(
                LocalDate.parse(
                        txtFechaInscripcion.getText()
                )
        );

        if (txtPosicionFinal.getText().isEmpty()) {

            inscripcion.setPosicionFinal(null);

        } else {

            inscripcion.setPosicionFinal(
                    Integer.parseInt(
                            txtPosicionFinal.getText()
                    )
            );
        }

        inscripcionControlador.insertar(inscripcion);

        JOptionPane.showMessageDialog(
                this,
                "Equipo inscrito"
        );

        cargarInscripciones();
        limpiarInscripcion();        // TODO add your handling code here:
    }//GEN-LAST:event_btnInscribirActionPerformed

    private void btnActualizarPosicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarPosicionActionPerformed
        int fila = tblInscripciones.getSelectedRow();

        if (fila == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione una inscripción"
            );

        } else {

            int id = Integer.parseInt(
                    tblInscripciones.getValueAt(
                            fila,
                            0
                    ).toString()
            );

            int posicion = Integer.parseInt(
                    txtPosicionFinal.getText()
            );

            inscripcionControlador.actualizarPosicion(
                    id,
                    posicion
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Posición actualizada"
            );

            cargarInscripciones();
        }    // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarPosicionActionPerformed

    private void btnEliminarInscripcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarInscripcionesActionPerformed
        int fila = tblInscripciones.getSelectedRow();

        if (fila == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione una inscripción"
            );

        } else {

            int id = Integer.parseInt(
                    tblInscripciones.getValueAt(
                            fila,
                            0
                    ).toString()
            );

            inscripcionControlador.eliminar(id);

            JOptionPane.showMessageDialog(
                    this,
                    "Inscripción eliminada"
            );

            cargarInscripciones();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarInscripcionesActionPerformed

    private void txtGuardarRondaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGuardarRondaActionPerformed
        Ronda ronda = new Ronda();

        ronda.setNumeroRonda(
                Integer.parseInt(
                        txtNumeroRonda.getText()
                )
        );

        ronda.setNombre(
                cmbNombreRonda.getSelectedItem().toString()
        );

        String datoTorneo = cmbTorneoRonda
                .getSelectedItem()
                .toString();

        int idTorneo = Integer.parseInt(
                datoTorneo.split(" - ")[0]
        );

        Torneo torneo = new Torneo();

        torneo.setIdTorneo(idTorneo);

        ronda.setTorneo(torneo);

        rondaControlador.insertar(ronda);

        JOptionPane.showMessageDialog(
                this,
                "Ronda guardada"
        );

        cargarRondas();
        limpiarRonda();        // TODO add your handling code here:
    }//GEN-LAST:event_txtGuardarRondaActionPerformed

    private void btnEliminarRondaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarRondaActionPerformed
        int fila = tblRondas.getSelectedRow();

        if (fila == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione una ronda"
            );

        } else {

            int id = Integer.parseInt(
                    tblRondas.getValueAt(
                            fila,
                            0
                    ).toString()
            );

            rondaControlador.eliminar(id);

            JOptionPane.showMessageDialog(
                    this,
                    "Ronda eliminada"
            );

            cargarRondas();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarRondaActionPerformed

    private void btnLimpiarRondaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarRondaActionPerformed
        limpiarRonda();        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarRondaActionPerformed

    private void cmbNombreRondaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNombreRondaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbNombreRondaActionPerformed

    private void btnAsignarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarJugadorActionPerformed
        Participacion participacion = new Participacion();

        String datoJugador = cmbJugadorParticipacion
                .getSelectedItem()
                .toString();

        int idJugador = Integer.parseInt(
                datoJugador.split(" - ")[0]
        );

        Jugador jugador = new Jugador();
        jugador.setIdUsuario(idJugador);

        participacion.setJugador(jugador);

        String datoEquipo = cmbEquipoParticipacion
                .getSelectedItem()
                .toString();

        int idEquipo = Integer.parseInt(
                datoEquipo.split(" - ")[0]
        );

        Equipo equipo = new Equipo();
        equipo.setIdEquipo(idEquipo);

        participacion.setEquipo(equipo);

        String datoTorneo = cmbTorneoParticipacion
                .getSelectedItem()
                .toString();

        int idTorneo = Integer.parseInt(
                datoTorneo.split(" - ")[0]
        );

        Torneo torneo = new Torneo();
        torneo.setIdTorneo(idTorneo);

        participacion.setTorneo(torneo);

        participacionJugadorControlador.insertar(participacion);

        JOptionPane.showMessageDialog(
                this,
                "Jugador asignado al equipo"
        );

        cargarParticipaciones();        // TODO add your handling code here:
    }//GEN-LAST:event_btnAsignarJugadorActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed

        MenuUsuario menu = new MenuUsuario(usuario);

        menu.setVisible(true);

        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionTorneosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionTorneosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionTorneosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionTorneosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarPosicion;
    private javax.swing.JButton btnAsignarJugador;
    private javax.swing.JButton btnEliminarInscripciones;
    private javax.swing.JButton btnEliminarParticipacion;
    private javax.swing.JButton btnEliminarRonda;
    private javax.swing.JButton btnEliminarTorneo;
    private javax.swing.JButton btnGuardarTorneo;
    private javax.swing.JButton btnInscribir;
    private javax.swing.JButton btnLimpiarRonda;
    private javax.swing.JButton btnLimpiarTorneo;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmbEquipoInscripcion;
    private javax.swing.JComboBox<String> cmbEquipoParticipacion;
    private javax.swing.JComboBox<String> cmbJuego;
    private javax.swing.JComboBox<String> cmbJugadorParticipacion;
    private javax.swing.JComboBox<String> cmbNombreRonda;
    private javax.swing.JComboBox<String> cmbTorneoInscripcion;
    private javax.swing.JComboBox<String> cmbTorneoParticipacion;
    private javax.swing.JComboBox<String> cmbTorneoRonda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblInscripciones;
    private javax.swing.JTable tblParticipaciones;
    private javax.swing.JTable tblRondas;
    private javax.swing.JTable tblTorneos;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtFechaInicio;
    private javax.swing.JTextField txtFechaInscripcion;
    private javax.swing.JButton txtGuardarRonda;
    private javax.swing.JTextField txtNombreTorneo;
    private javax.swing.JTextField txtNumeroRonda;
    private javax.swing.JTextField txtPosicionFinal;
    private javax.swing.JTextField txtPremio;
    // End of variables declaration//GEN-END:variables
}
