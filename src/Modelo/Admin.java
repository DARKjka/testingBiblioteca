
package Modelo;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Admin {
    private String usuario;
    private String password;
    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }  
   
    
    public Admin(){
        this.usuario="";
        this.password="";
    }
    
    public static Admin buscarAdmin(String usuario, String password){
        
        Admin administrador=new Admin();  
        File archivo=new File("Admin.txt");
       
        try{
            Scanner lector=new Scanner(archivo);
            while (lector.hasNext()) {
                String linea = lector.next();
                String[] tokens = linea.split(",");
                if ((tokens[0].equals(usuario))&&(tokens[1].equals(password))) {
                    administrador.setUsuario(tokens[0]);
                    administrador.setPassword(tokens[1]);
                    
                }
            }
            
            
        }catch(IOException e){
            System.out.println(e);
        }
        
        return administrador;             
    }

     
    
    
    
}
