/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.PartidoControlador;
import controlador.ArbitroControlador;
import controlador.SedeControlador;
import controlador.RondaControlador;
import controlador.EquipoControlador;

import modelo.Partido;
import modelo.Arbitro;
import modelo.Sede;
import modelo.Ronda;
import modelo.Equipo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;

/**
 *
 * @author LENOVO
 */
public class GestionPartidosVista extends javax.swing.JFrame {

    private PartidoControlador partidoControlador = new PartidoControlador();
    private ArbitroControlador arbitroControlador = new ArbitroControlador();
    private SedeControlador sedeControlador = new SedeControlador();
    private RondaControlador rondaControlador = new RondaControlador();
    private EquipoControlador equipoControlador = new EquipoControlador();

    private DefaultTableModel modeloPartidos;
    private DefaultTableModel modeloArbitros;
    private DefaultTableModel modeloSedes;
private Usuario usuario;
    /**
     * Creates new form GestionPartidosVista
     */
    public GestionPartidosVista(Usuario usuario) {

    initComponents();

    this.usuario = usuario;

    setLocationRelativeTo(null);

        setLocationRelativeTo(null);

        modeloPartidos = (DefaultTableModel) tblPartidos.getModel();
        modeloArbitros = (DefaultTableModel) tblArbitros.getModel();
        modeloSedes = (DefaultTableModel) tblSedes.getModel();
        

        cargarPartidos();
        cargarArbitros();
        cargarSedes();

        cargarComboRondas();
        cargarComboEquipos();
        cargarComboArbitros();
        cargarComboSedes();
    }

    public void cargarPartidos() {

        modeloPartidos.setRowCount(0);

        ArrayList<String[]> lista = partidoControlador.consultar();

        for (String[] p : lista) {

            modeloPartidos.addRow(p);
        }
    }

    public void cargarArbitros() {

        modeloArbitros.setRowCount(0);

        ArrayList<String[]> lista = arbitroControlador.consultar();

        for (String[] a : lista) {

            modeloArbitros.addRow(a);
        }
    }

    public void cargarSedes() {

        modeloSedes.setRowCount(0);

        ArrayList<String[]> lista = sedeControlador.consultar();

        for (String[] s : lista) {

            modeloSedes.addRow(s);
        }
    }

    public void cargarComboRondas() {

        cmbRonda.removeAllItems();

        ArrayList<String[]> lista = rondaControlador.consultar();

        for (String[] r : lista) {

            cmbRonda.addItem(
                    r[0] + " - " + r[2]
            );
        }
    }

    public void cargarComboEquipos() {

        cmbEquipo1.removeAllItems();
        cmbEquipo2.removeAllItems();

        ArrayList<String[]> lista = equipoControlador.consultar();

        for (String[] e : lista) {

            String dato = e[0] + " - " + e[2];

            cmbEquipo1.addItem(dato);
            cmbEquipo2.addItem(dato);
        }
    }

    public void cargarComboArbitros() {

        cmbArbitro.removeAllItems();

        ArrayList<String[]> lista = arbitroControlador.consultar();

        for (String[] a : lista) {

            cmbArbitro.addItem(
                    a[0] + " - " + a[1]
            );
        }
    }

    public void cargarComboSedes() {

        cmbSede.removeAllItems();

        ArrayList<String[]> lista = sedeControlador.consultar();

        for (String[] s : lista) {

            cmbSede.addItem(
                    s[0] + " - " + s[1]
            );
        }
    }

    public void limpiarPartido() {

        txtFechaPartido.setText("");
        txtHora.setText("");
        txtMarcador1.setText("");
        txtMarcador2.setText("");

        if (cmbRonda.getItemCount() > 0) {
            cmbRonda.setSelectedIndex(0);
        }

        if (cmbEquipo1.getItemCount() > 0) {
            cmbEquipo1.setSelectedIndex(0);
        }

        if (cmbEquipo2.getItemCount() > 0) {
            cmbEquipo2.setSelectedIndex(0);
        }

        if (cmbArbitro.getItemCount() > 0) {
            cmbArbitro.setSelectedIndex(0);
        }

        if (cmbSede.getItemCount() > 0) {
            cmbSede.setSelectedIndex(0);
        }
    }

    public void limpiarArbitro() {

        txtNombreArbitro.setText("");
        txtCorreoArbitro.setText("");
        txtPasswordArbitro.setText("");
        txtCertificacion.setText("");
        txtTorneosArbitrados.setText("");
    }

    public void limpiarSede() {

        txtNombreSede.setText("");
        txtCiudad.setText("");
        txtPaisSede.setText("");
        txtDireccion.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtNombreSede = new javax.swing.JTextField();
        txtCiudad = new javax.swing.JTextField();
        txtPaisSede = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        btnGuardarSede = new javax.swing.JButton();
        btnEliminarSede = new javax.swing.JButton();
        btnLimpiarSede = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSedes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtNombreArbitro = new javax.swing.JTextField();
        txtCorreoArbitro = new javax.swing.JTextField();
        txtPasswordArbitro = new javax.swing.JTextField();
        txtCertificacion = new javax.swing.JTextField();
        txtTorneosArbitrados = new javax.swing.JTextField();
        btnGuardarArbitro = new javax.swing.JButton();
        btnLimpiarArbitro = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblArbitros = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbRonda = new javax.swing.JComboBox<>();
        cmbEquipo1 = new javax.swing.JComboBox<>();
        cmbEquipo2 = new javax.swing.JComboBox<>();
        txtFechaPartido = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        cmbArbitro = new javax.swing.JComboBox<>();
        cmbSede = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMarcador1 = new javax.swing.JTextField();
        txtMarcador2 = new javax.swing.JTextField();
        btnGuardarPartido = new javax.swing.JButton();
        btnActualizarMarcador = new javax.swing.JButton();
        btnEliminarPartido = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPartidos = new javax.swing.JTable();
        btnLimpiarPartido = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jLabel16.setText("Nombre:");

        jLabel17.setText("Ciudad:");

        jLabel18.setText("Pais:");

        jLabel19.setText("Direccion:");

        btnGuardarSede.setText("Guardar");
        btnGuardarSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarSedeActionPerformed(evt);
            }
        });

        btnEliminarSede.setText("Eliminar");
        btnEliminarSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarSedeActionPerformed(evt);
            }
        });

        btnLimpiarSede.setText("Limpiar");
        btnLimpiarSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarSedeActionPerformed(evt);
            }
        });

        tblSedes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Ciudad", "Pais", "Direccion"
            }
        ));
        jScrollPane3.setViewportView(tblSedes);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardarSede))
                        .addGap(89, 89, 89)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btnEliminarSede)
                                .addGap(136, 136, 136)
                                .addComponent(btnLimpiarSede))
                            .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPaisSede, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreSede, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtNombreSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtPaisSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarSede)
                    .addComponent(btnEliminarSede)
                    .addComponent(btnLimpiarSede))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("SEDES", jPanel3);

        jLabel11.setText("Nombre:");

        jLabel12.setText("Contraseña:");

        jLabel13.setText("Correo:");

        jLabel14.setText("Torneos arbitrados:");

        jLabel15.setText("Certificacion:");

        btnGuardarArbitro.setText("Guardar");
        btnGuardarArbitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarArbitroActionPerformed(evt);
            }
        });

        btnLimpiarArbitro.setText("Limpiar");
        btnLimpiarArbitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarArbitroActionPerformed(evt);
            }
        });

        tblArbitros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Cedula", "Certfificaciones", "Torneos"
            }
        ));
        jScrollPane2.setViewportView(tblArbitros);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardarArbitro)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(88, 88, 88)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombreArbitro)
                                    .addComponent(txtCorreoArbitro)
                                    .addComponent(txtPasswordArbitro)
                                    .addComponent(txtCertificacion)
                                    .addComponent(txtTorneosArbitrados, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiarArbitro)))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreArbitro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtCorreoArbitro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtPasswordArbitro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtCertificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtTorneosArbitrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarArbitro)
                    .addComponent(btnLimpiarArbitro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        jTabbedPane1.addTab("ARBITROS", jPanel2);

        jLabel2.setText("Ronda:");

        jLabel3.setText("Equipo 1:");

        jLabel4.setText("Equipo 2:");

        jLabel5.setText("Fecha:");

        jLabel6.setText("Hora:");

        jLabel7.setText("Arbitro:");

        jLabel8.setText("Sede:");

        cmbRonda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbEquipo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbEquipo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbArbitro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbSede.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Marcador 2");

        jLabel10.setText("Marcador 1");

        btnGuardarPartido.setText("Guardar");
        btnGuardarPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPartidoActionPerformed(evt);
            }
        });

        btnActualizarMarcador.setText("Actualizar Marcador");
        btnActualizarMarcador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarMarcadorActionPerformed(evt);
            }
        });

        btnEliminarPartido.setText("Eliminar");
        btnEliminarPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPartidoActionPerformed(evt);
            }
        });

        tblPartidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Equipo 1", "Equipo 2", "Fecha", "Hora", "Marcador 1", "Marcador 2", "Arbitro", "Sede"
            }
        ));
        jScrollPane1.setViewportView(tblPartidos);

        btnLimpiarPartido.setText("Limpiar");
        btnLimpiarPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarPartidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFechaPartido, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(txtHora))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(52, 52, 52)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cmbEquipo2, javax.swing.GroupLayout.Alignment.LEADING, 0, 155, Short.MAX_VALUE)
                                    .addComponent(cmbEquipo1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbRonda, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(txtMarcador1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtMarcador2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel10)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel9))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(cmbArbitro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cmbSede, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(btnActualizarMarcador)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEliminarPartido))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnGuardarPartido)
                                .addGap(49, 49, 49)
                                .addComponent(btnLimpiarPartido)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(26, 26, 26))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbRonda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbEquipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cmbArbitro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cmbSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbEquipo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtFechaPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMarcador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMarcador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarPartido)
                    .addComponent(btnActualizarMarcador)
                    .addComponent(btnEliminarPartido)
                    .addComponent(btnLimpiarPartido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        jTabbedPane1.addTab("PARTIDOS", jPanel1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Gestion de Partidos");

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarSedeActionPerformed
limpiarSede();        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarSedeActionPerformed

    private void btnGuardarPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPartidoActionPerformed
        if (cmbRonda.getSelectedItem() == null
                || cmbEquipo1.getSelectedItem() == null
                || cmbEquipo2.getSelectedItem() == null
                || cmbArbitro.getSelectedItem() == null
                || cmbSede.getSelectedItem() == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Faltan datos"
            );

            return;
        }

        String datoEquipo1 = cmbEquipo1
                .getSelectedItem()
                .toString();

        String datoEquipo2 = cmbEquipo2
                .getSelectedItem()
                .toString();

        int idEquipo1 = Integer.parseInt(
                datoEquipo1.split(" - ")[0]
        );

        int idEquipo2 = Integer.parseInt(
                datoEquipo2.split(" - ")[0]
        );

        if (idEquipo1 == idEquipo2) {

            JOptionPane.showMessageDialog(
                    this,
                    "Los equipos deben ser diferentes"
            );

            return;
        }

        Partido partido = new Partido();

        String datoRonda = cmbRonda
                .getSelectedItem()
                .toString();

        int idRonda = Integer.parseInt(
                datoRonda.split(" - ")[0]
        );

        Ronda ronda = new Ronda();

        ronda.setIdRonda(idRonda);

        partido.setRonda(ronda);

        Equipo equipo1 = new Equipo();

        equipo1.setIdEquipo(idEquipo1);

        partido.setEquipo1(equipo1);

        Equipo equipo2 = new Equipo();

        equipo2.setIdEquipo(idEquipo2);

        partido.setEquipo2(equipo2);

        partido.setFecha(
                LocalDate.parse(
                        txtFechaPartido.getText()
                )
        );

        partido.setHora(
                LocalTime.parse(
                        txtHora.getText()
                )
        );

        if (txtMarcador1.getText().isEmpty()) {

            partido.setMarcadorEquipo1(null);

        } else {

            partido.setMarcadorEquipo1(
                    Integer.parseInt(
                            txtMarcador1.getText()
                    )
            );
        }

        if (txtMarcador2.getText().isEmpty()) {

            partido.setMarcadorEquipo2(null);

        } else {

            partido.setMarcadorEquipo2(
                    Integer.parseInt(
                            txtMarcador2.getText()
                    )
            );
        }

        String datoArbitro = cmbArbitro
                .getSelectedItem()
                .toString();

        int idArbitro = Integer.parseInt(
                datoArbitro.split(" - ")[0]
        );

        Arbitro arbitro = new Arbitro();

        arbitro.setIdUsuario(idArbitro);

        partido.setArbitro(arbitro);

        String datoSede = cmbSede
                .getSelectedItem()
                .toString();

        int idSede = Integer.parseInt(
                datoSede.split(" - ")[0]
        );

        Sede sede = new Sede();

        sede.setIdSede(idSede);

        partido.setSede(sede);

        partidoControlador.insertar(partido);

        JOptionPane.showMessageDialog(
                this,
                "Partido guardado"
        );

        cargarPartidos();

        limpiarPartido();    // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarPartidoActionPerformed

    private void btnActualizarMarcadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarMarcadorActionPerformed
        int fila = tblPartidos.getSelectedRow();

        if (fila == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione un partido"
            );

            return;
        }

        if (txtMarcador1.getText().isEmpty()
                || txtMarcador2.getText().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese los dos marcadores"
            );

            return;
        }

        int id = Integer.parseInt(
                tblPartidos.getValueAt(
                        fila,
                        0
                ).toString()
        );

        int marcador1 = Integer.parseInt(
                txtMarcador1.getText()
        );

        int marcador2 = Integer.parseInt(
                txtMarcador2.getText()
        );

        partidoControlador.actualizarMarcador(
                id,
                marcador1,
                marcador2
        );

        JOptionPane.showMessageDialog(
                this,
                "Marcador actualizado"
        );

        cargarPartidos();        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarMarcadorActionPerformed

    private void btnEliminarPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPartidoActionPerformed
        int fila = tblPartidos.getSelectedRow();

        if (fila == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione un partido"
            );

            return;
        }

        int id = Integer.parseInt(
                tblPartidos.getValueAt(
                        fila,
                        0
                ).toString()
        );

        partidoControlador.eliminar(id);

        JOptionPane.showMessageDialog(
                this,
                "Partido eliminado"
        );

        cargarPartidos();        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarPartidoActionPerformed

    private void btnLimpiarPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarPartidoActionPerformed
limpiarPartido();        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarPartidoActionPerformed

    private void btnGuardarArbitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarArbitroActionPerformed
Arbitro arbitro = new Arbitro();

arbitro.setNombre(
        txtNombreArbitro.getText()
);

arbitro.setCorreo(
        txtCorreoArbitro.getText()
);

arbitro.setPassword(
        txtPasswordArbitro.getText()
);

arbitro.setEstado("ACTIVO");

arbitro.setNivelCertificacion(
        txtCertificacion.getText()
);

arbitro.setTorneosArbitrados(
        Integer.parseInt(
                txtTorneosArbitrados.getText()
        )
);

arbitroControlador.insertar(arbitro);

JOptionPane.showMessageDialog(
        this,
        "Árbitro guardado"
);

cargarArbitros();

cargarComboArbitros();

limpiarArbitro();        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarArbitroActionPerformed

    private void btnLimpiarArbitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarArbitroActionPerformed
limpiarArbitro();        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarArbitroActionPerformed

    private void btnGuardarSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarSedeActionPerformed
Sede sede = new Sede();

sede.setNombre(
        txtNombreSede.getText()
);

sede.setCiudad(
        txtCiudad.getText()
);

sede.setPais(
        txtPaisSede.getText()
);

sede.setDireccion(
        txtDireccion.getText()
);

sedeControlador.insertar(sede);

JOptionPane.showMessageDialog(
        this,
        "Sede guardada"
);

cargarSedes();

cargarComboSedes();

limpiarSede();        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarSedeActionPerformed

    private void btnEliminarSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarSedeActionPerformed
int fila = tblSedes.getSelectedRow();

if (fila == -1) {

    JOptionPane.showMessageDialog(
            this,
            "Seleccione una sede"
    );

    return;
}

int id = Integer.parseInt(
        tblSedes.getValueAt(
                fila,
                0
        ).toString()
);

sedeControlador.eliminar(id);

JOptionPane.showMessageDialog(
        this,
        "Sede eliminada"
);

cargarSedes();

cargarComboSedes();        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarSedeActionPerformed

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
            java.util.logging.Logger.getLogger(GestionPartidosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionPartidosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionPartidosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionPartidosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarMarcador;
    private javax.swing.JButton btnEliminarPartido;
    private javax.swing.JButton btnEliminarSede;
    private javax.swing.JButton btnGuardarArbitro;
    private javax.swing.JButton btnGuardarPartido;
    private javax.swing.JButton btnGuardarSede;
    private javax.swing.JButton btnLimpiarArbitro;
    private javax.swing.JButton btnLimpiarPartido;
    private javax.swing.JButton btnLimpiarSede;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmbArbitro;
    private javax.swing.JComboBox<String> cmbEquipo1;
    private javax.swing.JComboBox<String> cmbEquipo2;
    private javax.swing.JComboBox<String> cmbRonda;
    private javax.swing.JComboBox<String> cmbSede;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblArbitros;
    private javax.swing.JTable tblPartidos;
    private javax.swing.JTable tblSedes;
    private javax.swing.JTextField txtCertificacion;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtCorreoArbitro;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFechaPartido;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtMarcador1;
    private javax.swing.JTextField txtMarcador2;
    private javax.swing.JTextField txtNombreArbitro;
    private javax.swing.JTextField txtNombreSede;
    private javax.swing.JTextField txtPaisSede;
    private javax.swing.JTextField txtPasswordArbitro;
    private javax.swing.JTextField txtTorneosArbitrados;
    // End of variables declaration//GEN-END:variables
}
