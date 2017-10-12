/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Libro;
import Modelo.Persona;
import Modelo.Prestamo;
import static Modelo.ValidaRut.validaRut;
import Vista.Prestar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;


public class controlPrestamo implements ActionListener {
    Prestar vistaPrestar=new Prestar();
    Libro book=new Libro();
    Persona cliente=new Persona();    
    
    public controlPrestamo(Prestar prestar, Libro book){
        this.vistaPrestar=prestar;
        this.book=book;
        this.vistaPrestar.btnAceptar.addActionListener(this);
        this.vistaPrestar.btnCancelar.addActionListener(this);
    }
    
    public void iniciarPrestamo(){
        vistaPrestar.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e ){
        
        String rut=vistaPrestar.txtRut.getText();
        String nombre=vistaPrestar.txtNombre.getText();
        String direccion=vistaPrestar.txtDireccion.getText();
        
        if(e.getSource()==vistaPrestar.btnAceptar){
            cliente.setRut(rut);
            cliente.setNombre(nombre);
            cliente.setDireccion(direccion);
            if(!validaRut(cliente.getRut())){
                JOptionPane.showMessageDialog(vistaPrestar,"RUT inválido!");                            
            }else{
                Date fecha=new Date();
                Prestamo prest=new Prestamo(cliente, book,fecha);
                book.prestarLibro(book);
                prest.prestar();
                JOptionPane.showMessageDialog(vistaPrestar,"Libro Prestado!");
                vistaPrestar.setVisible(false);
            }            
        }
        
        if(e.getSource()==vistaPrestar.btnCancelar){
            vistaPrestar.setVisible(false);
        }     
        
        
    }
    
}
