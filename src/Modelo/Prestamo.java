
package Modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Prestamo {
    private Persona persona;
    private Libro libro;
    private Date fecha;  
    
    public Prestamo(Persona cliente, Libro book, Date date){
        this.fecha = date;        
        this.persona=cliente;
        this.libro=book;        
    }

    /**
     * @return the persona
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * @param persona the persona to set
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * @return the libro
     */
    public Libro getLibro() {
        return libro;
    }

    /**
     * @param libro the libro to set
     */
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }    
    
    public void prestar(){
        File archivo=new File("Prestamos.txt");        
        try{
            FileWriter fw=new FileWriter("Prestamos.txt",true);
            fw.write("Codigo Libro: "+getLibro().getCodigo()+" Titulo: "+getLibro().getTitulo()+" Cliente: " + getPersona().getNombre()+" Rut: "+getPersona().getRut()+" Direccion: "+getPersona().getDireccion()+" Fecha: "+ this.getFecha());
            fw.write("\r\n");
            fw.flush();
            fw.close();
        }catch(IOException e){
            System.out.println(e);
        }
        
    }    
    
    
    public void devolver(Libro libro){
        
    }
    
    
}

