
package biblioteca;

import Controlador.controlLogin;
import Modelo.Admin;
import Vista.Login;
import java.util.Date;


public class Biblioteca {

    
    public static void main(String[] args) {
        
        Login login=new Login();
        Admin admin=new Admin();
        controlLogin ventana=new controlLogin(login, admin);
        ventana.iniciarLogin();
          
       
    }
    
}
