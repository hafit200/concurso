/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vista.MenuOrganizador;

/**
 *
 * @author LENOVO
 */
public class MenuOrganizadorControlador {

    private MenuOrganizador vista;

    public MenuOrganizadorControlador(MenuOrganizador vista) {
        this.vista = vista;
    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
}
