/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Libro;
import static Modelo.Libro.buscarlibro;
import Modelo.Prestamo;
import Vista.Menu;
import Vista.Prestar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class controlMenu implements ActionListener {
    
    Menu menu=new Menu();
    Libro book=new Libro();    
    
    public controlMenu(Menu menu){
        
        this.menu=menu;
        this.menu.btnConsultar.addActionListener(this);
        this.menu.btnPrestar.addActionListener(this);
        this.menu.btnDevolver.addActionListener(this);
        
    }
    
    public void iniciarMenu(){
        this.menu.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        
        String consultar=menu.txtBuscar.getText();
        String prestar=menu.txtPrestar.getText();
        String devolver=menu.txtDevolver.getText();
        
        
        if(e.getSource()==menu.btnConsultar){            
            book=buscarlibro(consultar);
            if(book.getCodigo().equals("")){
                JOptionPane.showMessageDialog(menu,"No existe código! Intente nuevamente");
            }else{
                JOptionPane.showMessageDialog(menu,"Codigo: "+book.getCodigo()+"\nTitulo: "+book.getTitulo()+"\nAño: "+book.getAño()+"\nAutor: "+book.getAutor()+"\nEstanteria: "+book.getEstante()+"\nDisponibilidad: "+book.getDisponibilidad());
            }            
                      
        }
        
        if(e.getSource()==menu.btnPrestar){
            book=buscarlibro(prestar);
            if(book.getCodigo().equals("")){
                JOptionPane.showMessageDialog(menu,"No existe código! Intente nuevamente");
            }else{
                if(book.getDisponibilidad().equals("disponible")){
                    JOptionPane.showMessageDialog(menu,"Codigo: "+book.getCodigo()+"\nTitulo: "+book.getTitulo()+"\nAño: "+book.getAño()+"\nAutor: "+book.getAutor()+"\nEstanteria: "+book.getEstante()+"\nDisponibilidad: "+book.getDisponibilidad());
                    Prestar ventanaPrestamo=new Prestar();
                    controlPrestamo vistaPrest=new controlPrestamo(ventanaPrestamo,book);
                    vistaPrest.iniciarPrestamo();
                }else{
                    JOptionPane.showMessageDialog(menu, "Libro no disponible!");
                }                
            }           
        }
        
        if(e.getSource()==menu.btnDevolver){
            book=buscarlibro(devolver);
            
            if(book.getCodigo().equals("")){
                JOptionPane.showMessageDialog(menu,"No existe código! Intente nuevamente");            
            }
            if(book.getDisponibilidad().equals("disponible")){
                JOptionPane.showMessageDialog(menu,"El Libro ya se encontraba disponible, intente nuevamente!");
            }
            if(book.getDisponibilidad().equals("no_disponible")){
                book.devolverLibro(book);
                JOptionPane.showMessageDialog(menu,"El Libro fue devuelto con éxito!");                
            }
            
        }
        
        
        
        
        
    }
}
