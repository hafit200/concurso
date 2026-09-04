/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package vista;

import controlador.ConexionBDD;
import controlador.EquipoControlador;
import java.time.LocalDate;

/**
 *
 * @author Asus
 */
import vista.GestionEquiposVista;

import java.sql.Connection;


public class Main {

    public static void main(String[] args) {

        LoginVista login = new LoginVista();

        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
}