
package Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Libro {

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the año
     */
    public String getAño() {
        return año;
    }

    /**
     * @param año the año to set
     */
    public void setAño(String año) {
        this.año = año;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the estante
     */
    public String getEstante() {
        return estante;
    }

    /**
     * @param estante the estante to set
     */
    public void setEstante(String estante) {
        this.estante = estante;
    }

    /**
     * @return the disponibilidad
     */
    public String getDisponibilidad() {
        return disponibilidad;
    }

    /**
     * @param disponibilidad the disponibilidad to set
     */
    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
    private String codigo;
    private String titulo;
    private String año;
    private String autor;
    private String estante;
    private String disponibilidad;
    
    
    public Libro(){
        this.codigo="";
        this.titulo="";
        this.año="";
        this.estante="";
        this.disponibilidad="";
        this.autor="";
    }
    
    public static Libro buscarlibro(String code){
        Libro book=new Libro();
        File archivo=new File("Libros.txt");
        
        try{
            Scanner lector=new Scanner(archivo);
            while (lector.hasNext()) {
                String linea = lector.next();
                String[] tokens = linea.split(",");
                if (tokens[0].equals(code)) {
                    
                    book.setCodigo(tokens[0]);
                    book.setTitulo(tokens[1]);
                    book.setAño(tokens[2]);
                    book.setAutor(tokens[3]);
                    book.setEstante(tokens[4]);
                    book.setDisponibilidad(tokens[5]);
                }
            }
            lector.close();
            
        }catch(IOException e){
            System.out.println(e);
        }       
        return book;
    }
    
    public void prestarLibro(Libro libro){
        File archivo=new File("Libros.txt");
        Libro book=new Libro();
        String aux = "carroAux.csv";//Ruta Nuevo documento
        File archivoAux = new File(aux);//Nuevo documento
        
        try{    
            
            Scanner lector=new Scanner(archivo);
            while(lector.hasNext()){
                
                String linea = lector.next();
                String[] tokens = linea.split(",");
                try {

                    FileWriter fw = new FileWriter(aux, true);

                    book.setCodigo(tokens[0]);
                    book.setTitulo(tokens[1]);
                    book.setAño(tokens[2]);
                    book.setAutor(tokens[3]);
                    book.setEstante(tokens[4]);
                    if (tokens[0].equals(libro.getCodigo())) {
                        book.setDisponibilidad("no_disponible");
                    }else{
                        book.setDisponibilidad(tokens[5]);
                    }
                    fw.write(book.getCodigo() + "," + book.getTitulo() + "," + book.getAño() + "," + book.getAutor() + "," + book.getEstante() + "," + book.getDisponibilidad()+"\r\n");
                    fw.flush();
                    fw.close();

                } catch (IOException e) {
                }
            }
            lector.close();
            eliminararchivo("Libros.txt");
            archivoAux.renameTo(archivo);
            
        }catch(IOException e){
            System.out.println(e);
        }
        
        
    }
    
    public void devolverLibro(Libro libro){
        File archivo=new File("Libros.txt");
        Libro book=new Libro();
        String aux = "carroAux.csv";//Ruta Nuevo documento
        File archivoAux = new File(aux);//Nuevo documento
        
        try{    
            
            Scanner lector=new Scanner(archivo);
            while(lector.hasNext()){
                
                String linea = lector.next();
                String[] tokens = linea.split(",");
                try {

                    FileWriter fw = new FileWriter(aux, true);

                    book.setCodigo(tokens[0]);
                    book.setTitulo(tokens[1]);
                    book.setAño(tokens[2]);
                    book.setAutor(tokens[3]);
                    book.setEstante(tokens[4]);
                    if (tokens[0].equals(libro.getCodigo())) {
                        book.setDisponibilidad("disponible");
                    }else{
                        book.setDisponibilidad(tokens[5]);
                    }
                    fw.write(book.getCodigo() + "," + book.getTitulo() + "," + book.getAño() + "," + book.getAutor() + "," + book.getEstante() + "," + book.getDisponibilidad()+"\r\n");
                    fw.flush();
                    fw.close();

                } catch (IOException e) {
                }
            }
            lector.close();
            eliminararchivo("Libros.txt");
            archivoAux.renameTo(archivo);
            
        }catch(IOException e){
            System.out.println(e);
        }
    }
    public static void eliminararchivo(String archivo) {

        File fichero = new File(archivo);

        if (fichero.delete()) {

            System.out.println("");

        } else {
            System.out.println("no se puede eliminar fichero");
        }

    }
    
    
}
