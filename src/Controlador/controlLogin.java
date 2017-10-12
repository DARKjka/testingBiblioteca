/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Admin;
import static Modelo.Admin.buscarAdmin;
import Modelo.Persona;
import Vista.Login;
import Vista.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose
 */
public class controlLogin implements ActionListener {
    
    Login login=new Login();
    Admin admin=new Admin();
    
    public controlLogin(Login login, Admin admin){
        this.admin=admin;
        this.login=login;
        this.login.btnIngresar.addActionListener(this);
    }
 
    public void iniciarLogin() {
        this.login.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String usuario = login.txtUsuario.getText();
        String contraseña = login.txtContraseña.getText();

        admin = buscarAdmin(usuario, contraseña);
        
        if (e.getSource() == login.btnIngresar) {
            
            if (admin.getUsuario().equals("")) {
                JOptionPane.showMessageDialog(login, "Usuario no Existe!, Intente nuevamente");
            } else {
                Menu menu=new Menu();
                controlMenu vistaMenu=new controlMenu(menu);
                vistaMenu.iniciarMenu();
                login.setVisible(false);
            }

        }

        
        
        
    }
    
}
